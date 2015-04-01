/*
 * Copyright (c) 2011 by Guoqiang Yu, all rights reserved.
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

import com.qq.map.qqappointment.model.User;

/**
 *
 * @author Guoqiang Yu
 */
public class DogetUserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession(true);//如果没有该session，则自动创建一个新的
        PrintWriter out = response.getWriter();//获得一个向客户端写东西的对象
        response.setContentType("application/json");//设置返回内容为文本html

        JSONObject json = new JSONObject();

        try {
            User userInfo = new User();
            //       String vcode = (String) session.getAttribute("vcode");
            //    String inputVcode = request.getParameter("vcode");

        } catch (Exception e) {
            out.println("{error:'注册失败: " + e.getMessage() + "'}");
        } finally {

            out.print(json.toString());

            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
        //super.doPost(request, response);
    }

}
