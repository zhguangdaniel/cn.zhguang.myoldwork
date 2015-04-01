/*
 * Copyright (c) 2011 by Guoqiang Yu, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.qq.map.qqappointment.dao.AppointmentDAO;
import com.qq.map.qqappointment.model.Appointment;

/**
 *
 * @author Guoqiang Yu
 */
public class DoGetAllAppointmentServlet extends HttpServlet {

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

            List<Appointment> appointList = new AppointmentDAO().getAllAppointments();
            int count = 1;
            if (appointList.size() > 0) {
                JSONArray appointmentArray = new JSONArray();
                for (Appointment i : appointList) {

                    JSONObject memberJsonObject = new JSONObject().put("id", i.getId()).put("title", i.getTitle()).put(
                            "type", i.getType()).put("introduction", i.getIntroduction())
                            .put("address", i.getAddress()).put("attendeeCount", i.getAttendeeCount()).put(
                                    "attendeeLimited", i.getAttendeeLimited()).put("attendType", i.getAttendType())
                            .put("status", i.getStatus()).put("startTime", i.getStartTime()).put("endTime",
                                    i.getEndTime()).put("latitude", i.getLatitude()).put("longitude", i.getLongitude())
                            .put("iconUrl", i.getIconUrl());
                    appointmentArray.put(count, memberJsonObject);
                    count++;

                }
                json.put("appoint", appointmentArray);

            }

        } catch (Exception e) {
            out.println("{error:'获取全部appointments失败 " + e.getMessage() + "'}");
        } finally {

            out.print(json.toString());

            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
        //super.doPost(request, response);
    }

}
