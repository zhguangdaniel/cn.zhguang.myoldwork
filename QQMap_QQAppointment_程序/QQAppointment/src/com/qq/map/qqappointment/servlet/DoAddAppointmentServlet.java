/*
 * Copyright (c) 2011 by Guoqiang Yu, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.qq.map.qqappointment.dao.AppointmentDAO;
import com.qq.map.qqappointment.definition.AppointmentTypeEnum;
import com.qq.map.qqappointment.model.Appointment;
import com.qq.map.qqappointment.model.User;
import com.qq.map.qqappointment.util.JSON;

/**
 *
 * @author Guoqiang Yu
 */
public class DoAddAppointmentServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

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
            //从界面获得参数
            String appTitle = request.getParameter("apptitle");
            String appType = request.getParameter("apptype");
            int attendType = Integer.parseInt(request.getParameter("attendtype"));
            int userCountLimited = Integer.parseInt(request.getParameter("userCountLimited"));
            String appIconUrl = request.getParameter("appIconUrl");
            String appImageUrl = request.getParameter("appImageUrl");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String address = request.getParameter("address");
            String lng = request.getParameter("lng");
            String lat = request.getParameter("lat");
            String appintro = request.getParameter("appintro");

            Appointment appointment = new Appointment();

            appointment.setAttendeeLimited(userCountLimited);
            appointment.setTitle(appTitle);
            appointment.setType(appType);
            appointment.setAttendType(attendType);
            appointment.setStatus(1);
            appointment.setAddress(address);
            appointment.setLatitude(lat);
            appointment.setLongitude(lng);
            appointment.setIntroduction(appintro);
            appointment.setAppImageUrl(appImageUrl);
            appointment.setIconUrl(appIconUrl);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            appointment.setStartTime(sdf.parse(startTime));
            appointment.setEndTime(sdf.parse(endTime));
            appointment.setCreator((User) session.getAttribute("user"));

            new AppointmentDAO().save(appointment);

            JSON.put(json, "msg", "success");
            JSON.put(json, "appId", appointment.getId());
            JSON.put(json, "title", appTitle);
            JSON.put(json, "type", AppointmentTypeEnum.getShortTypeByValue(appType));
            JSON.put(json, "iconUrl", appIconUrl);
            JSON.put(json, "attendeeCount", String.valueOf(appointment.getAttendeeCount()));
            JSON.put(json, "startTime", startTime);
            JSON.put(json, "endTime", endTime);
            JSON.put(json, "lat", lat);
            JSON.put(json, "lng", lng);
            JSON.put(json, "address", address);
            JSON.put(json, "creator", appointment.getCreator().getNickName());
        } catch (Exception e) {
            JSON.put(json, "error", "注册失败: " + e.getMessage());
        } finally {
            out.print(json.toString());
            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
    }

}
