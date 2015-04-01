/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import java.util.List;

import com.qq.map.qqappointment.hibernate.HibernateDAO;
import com.qq.map.qqappointment.model.Appointment;

/**
 *
 * @author 张广
 */
public class AppointmentDAO extends HibernateDAO implements IAppointmentDAO {

    @Override
    public Appointment getAppointmentById(String id) {
        // TODO Auto-generated method stub
        return getObject(Appointment.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Appointment> getAllAppointments() {
        String hsql = "from Appointment a order by upper(a.startTime)";
        return (List<Appointment>) getObjects(hsql);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Appointment> getTopAppointments(int top) {
        String hsql = "from Appointment a order by upper(a.startTime)";
        return (List<Appointment>) getTopObjects(hsql, top);
    }

    @Override
    public void save(Appointment app) {
        // TODO Auto-generated method stub
        if (app == null)
            return;

        saveObject(app);
    }

    @Override
    public void delete(String appointmentId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Appointment appointment) {
        // TODO Auto-generated method stub

        if (appointment == null)
            return;

        updateObject(appointment);

    }

}
