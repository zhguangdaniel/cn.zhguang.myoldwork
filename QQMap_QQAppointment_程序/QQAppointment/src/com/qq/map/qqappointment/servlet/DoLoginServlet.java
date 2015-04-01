/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.qq.map.qqappointment.dao.UserDAO;
import com.qq.map.qqappointment.model.User;
import com.qq.map.qqappointment.util.JSON;

/**
 *
 * @author 张广
 */
public class DoLoginServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        HttpSession session = request.getSession(true);//如果没有该session，则自动创建一个新的
        PrintWriter out = response.getWriter();//获得一个向客户端写东西的对象
        response.setContentType("application/json");//设置返回内容为文本html
        JSONObject json = new JSONObject();
        try {
            //从界面获得参数
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User u = new UserDAO().getUserByUserName(username);
            if (u == null) {
                JSON.put(json, "error", "用户不存在");
            } else {
                if (u.getPassword().equals(password)) {
                    session.setAttribute("isLogin", new String("true"));
                    session.setAttribute("user", u);
                    JSON.put(json, "msg", "success");
                } else {
                    JSON.put(json, "error", "密码错误");
                }
            }
        } catch (Exception e) {
            session.setAttribute("isLogin", new String("false"));
            JSON.put(json, "error", "登录失败: " + e.getMessage());
        } finally {
            out.println(json.toString());
            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
    }
}
