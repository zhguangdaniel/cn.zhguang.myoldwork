/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.config;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.qq.map.qqappointment.exception.QQAppointmentException;

/**
 *Dao 配置信息
 * @author 张广
 */
public class DaoConfig {

    private String id;

    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Object instance;

    /**
     * 得到配置的对象的实例
     */
    @SuppressWarnings("unchecked")
    public Object getInstance() {
        if (null != instance)
            return instance;

        try {
            Class cls = Class.forName(getType());
            instance = cls.newInstance();
            return instance;
        } catch (Exception ex) {
            throw new QQAppointmentException("Couldn't find class:" + getType());
        }
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
