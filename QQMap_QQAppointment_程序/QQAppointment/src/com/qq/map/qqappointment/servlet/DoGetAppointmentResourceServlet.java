/*
 * Copyright (c) 2011 by Guoqiang Yu, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
import com.qq.map.qqappointment.model.Resource;

/**
 *
 * @author Guoqiang Yu
 */
public class DoGetAppointmentResourceServlet extends HttpServlet {

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
        String appointmentID = "402881ea307d93f401307d9436cf0000";

        JSONObject json = new JSONObject();

        try {

            Appointment appointment = new AppointmentDAO().getAppointmentById(appointmentID);

            if (appointment != null) {
                Set<Resource> resources = appointment.getResources();
                JSONArray resourcesArray = new JSONArray();

                Iterator<Resource> it = resources.iterator();
                while (it.hasNext()) {
                    Resource resource = it.next();

                    JSONObject memberJsonObject = new JSONObject().put("resourceid", resource.getId()).put(
                            "resourceName", resource.getResourceName()).put("type", resource.getType()).put(
                            "uploadtime", resource.getUploadtime()).put("resourceUri", resource.getResourceUri()).put(
                            "introduction", resource.getIntroduction()).put("creator",
                            resource.getCreator().getNickName());
                    resourcesArray.put(memberJsonObject);

                }

                json.put("resource", resourcesArray);
            }

        } catch (Exception e) {
            out.println("{error:'获取appointment资源失败: " + e.getMessage() + "'}");
        } finally {

            out.print(json.toString());

            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
        //super.doPost(request, response);
    }

}
