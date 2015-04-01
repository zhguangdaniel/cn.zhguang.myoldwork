/*
 * Copyright (c) 2011 by Guoqiang Yu, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.qq.map.qqappointment.dao.AppointmentDAO;
import com.qq.map.qqappointment.dao.UserDAO;
import com.qq.map.qqappointment.model.Appointment;
import com.qq.map.qqappointment.model.User;
import com.qq.map.qqappointment.util.JSON;

/**
 *
 * @author Guoqiang Yu
 */
public class DoUserAttendAppointmentServlet extends HttpServlet {

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

        //        String appointmentID = request.getParameter("appointmentID");
        //        String userID = request.getParameter("userID");

        String appointmentID = "402881ea307d93f401307d9436cf0000";
        String userID = "2c925a5b307d9e2101307da045390000";

        try {
            User user = new UserDAO().getUserById(userID);
            Appointment appointment = new AppointmentDAO().getAppointmentById(appointmentID);

            Set<User> users = new HashSet<User>(0);

            users = appointment.getAttendees();

            System.out.println(users.size());

            users.add(user);

            System.out.println(users.size());

            appointment.setAttendees(users);

            new AppointmentDAO().update(appointment);

            JSON.put(json, "msg", "success");

        } catch (Exception e) {
            out.println("{error:'参加失败: " + e.getMessage() + "'}");
        } finally {

            out.print(json.toString());
            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
        //super.doPost(request, response);
    }

}
