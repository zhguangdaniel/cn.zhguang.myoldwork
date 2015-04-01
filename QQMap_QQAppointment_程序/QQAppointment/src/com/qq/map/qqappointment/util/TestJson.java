/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.util;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.qq.map.qqappointment.model.Appointment;

/**
 *
 * @author 张广
 */
public class TestJson {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Appointment appointment = new Appointment();

        appointment.setAttendeeCount(100);
        appointment.setAttendeeLimited(200);
        appointment.setTitle("朋友聚会");
        appointment.setType("聚会");
        appointment.setAttendType(2);
        appointment.setStatus(1);
        appointment.setAddress("广州市大学城华南理工大学");
        appointment.setLatitude("32.11111");
        appointment.setLongitude("112.123412");
        appointment.setIntroduction("中山大学05级网络工程全体同学将出会");

        //Gson gson2 = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        Gson gson = new Gson();
        String obj2 = gson.toJson(appointment);
        System.out.println(obj2);

        try {
            System.out.println(JSONObject.valueToString(appointment));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
