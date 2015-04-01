/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import java.util.List;

import com.qq.map.qqappointment.model.Appointment;

/**
 *
 * @author 张广
 */
public interface IAppointmentDAO {
    /**
     * 保存Appointment对象
     * @param app
     */
    public void save(Appointment app);

    /**
     *  根据Appointment ID得到Appointment信息
     * @param id
     * @return
     */
    public Appointment getAppointmentById(String id);

    /**
     * 返回全部的appointment
     * @return
     */
    public List<Appointment> getAllAppointments();

    /**
     * 返回前top条记录
     * @return
     */
    public List<Appointment> getTopAppointments(int top);

    /**
     * 更新appointment
     * @param appointment
     */
    public void update(Appointment appointment);

    /**
     * 删除
     * @param appointmentId
     */
    public void delete(String appointmentId);
}
