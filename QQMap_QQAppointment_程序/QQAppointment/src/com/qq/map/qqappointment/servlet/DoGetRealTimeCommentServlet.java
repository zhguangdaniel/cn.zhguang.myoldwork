/*
 * Copyright (c) 2011 by Guoqiang Yu, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.qq.map.qqappointment.dao.AppointmentDAO;
import com.qq.map.qqappointment.model.Appointment;
import com.qq.map.qqappointment.model.Comment;
import com.qq.map.qqappointment.util.CommentComparatorByCreateTime;

/**
 *
 * @author Guoqiang Yu
 */
public class DoGetRealTimeCommentServlet extends HttpServlet {

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

        //   String appointmentID = request.getParameter("appointmentID");
        //  String lastCommentCreateTime= request.getParameter("lastCommentCreateTime");
        String appointmentID = "402881ea307d93f401307d9436cf0000";
        String lastCommentCreateTime = "2011-06-12 12:08:13"; //最后一条comment的创建j

        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;

        JSONObject json = new JSONObject();

        try {
            Appointment appointment = new AppointmentDAO().getAppointmentById(appointmentID);

            date1 = DateFormat.parse(lastCommentCreateTime);

            if (appointment != null) {
                Set<Comment> comments = appointment.getComments();

                List<Comment> commentsList = new ArrayList<Comment>();
                Iterator<Comment> it = comments.iterator();
                while (it.hasNext()) {
                    commentsList.add(it.next());
                }

                CommentComparatorByCreateTime commentComparator = new CommentComparatorByCreateTime();

                Collections.sort(commentsList, commentComparator);

                JSONArray commentsArray = new JSONArray();

                for (Comment comment : commentsList) {
                    if (comment.getCreateTime().after(date1)) {
                        JSONObject memberJsonObject = new JSONObject().put("commentId", comment.getId()).put(
                                "parentComment", comment.getParentComment()).put("content", comment.getContent()).put(
                                "createTime", comment.getCreateTime()).put("modifyTime", comment.getModifyTime()).put(
                                "creator", comment.getCreator().getNickName());
                        commentsArray.put(memberJsonObject);
                    }

                }

                json.put("comment", commentsArray);
            }

        } catch (Exception e) {
            out.println("{error:'获取RealTimeComment失败: " + e.getMessage() + "'}");
        } finally {

            out.print(json.toString());

            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
        //super.doPost(request, response);
    }
}
