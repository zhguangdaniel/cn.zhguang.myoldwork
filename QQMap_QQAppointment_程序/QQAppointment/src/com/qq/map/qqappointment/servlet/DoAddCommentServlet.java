/*
 * Copyright (c) 2011 by Guoqiang Yu, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.qq.map.qqappointment.dao.AppointmentDAO;
import com.qq.map.qqappointment.dao.CommentDAO;
import com.qq.map.qqappointment.dao.UserDAO;
import com.qq.map.qqappointment.model.Appointment;
import com.qq.map.qqappointment.model.Comment;
import com.qq.map.qqappointment.model.User;
import com.qq.map.qqappointment.util.JSON;

/**
 *
 * @author Guoqiang Yu
 */
public class DoAddCommentServlet extends HttpServlet {
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
        //        String appointmentID = request.getParameter("appointmentID");
        //        String userID = request.getParameter("userID");
        // String commentID = request.getParameter("commentID");

        String appointmentID = "402881ea307d93f401307d9436cf0000";
        String userID = "402881ea307da54201307da654cf0001";
        String commentID = "0";

        String content = "AppointMent comment content4";

        //设置时间
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date.getTime();
        DateFormat.format(date);
        Date createTime = date;
        Date modifyTime = date;
        Comment parentComment = null;

        JSONObject json = new JSONObject();

        try {
            User user = new UserDAO().getUserById(userID);
            Appointment appointment = new AppointmentDAO().getAppointmentById(appointmentID);

            if (!commentID.equals("0")) {
                parentComment = new CommentDAO().getCommentById(commentID);
            }

            Comment comment = new Comment();
            comment.setContent(content);
            comment.setCreator(user);
            comment.setOrgAppointment(appointment);
            comment.setCreateTime(createTime);
            comment.setModifyTime(modifyTime);
            comment.setParentComment(parentComment);

            new CommentDAO().save(comment);

            JSON.put(json, "msg", "success");

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
