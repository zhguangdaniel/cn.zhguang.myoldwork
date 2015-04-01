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
public class DoRegisterServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
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
            User userInfo = new User();
            String vcode = (String) session.getAttribute("vcode");
            String inputVcode = request.getParameter("vcode");

            if (!inputVcode.equals(vcode)) {
                //  out.println("{error:'验证码错误！'}");
                JSON.put(json, "error", "验证码错误");
            } else {
                userInfo.setUserName(request.getParameter("userName"));
                userInfo.setNickName(request.getParameter("nickName"));
                userInfo.setPassword(request.getParameter("password"));
                String userIcon = request.getParameter("userIconUrl");
                if (userIcon == null || userIcon.equals(""))
                    userIcon = "/image/defaultUserIcon.png";
                userInfo.setIconUrl(userIcon);
                userInfo.setKeyWords(request.getParameter("userKeyWords"));
                new UserDAO().save(userInfo);
                session.setAttribute("user", userInfo);
                session.setAttribute("isLogin", "true");
                JSON.put(json, "msg", "success");
            }
        } catch (Exception e) {
            JSON.put(json, "error", "注册失败: " + e.getMessage());
        } finally {
            out.print(json.toString());
            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
    }
}
