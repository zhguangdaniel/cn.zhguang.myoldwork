/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.config;

import java.util.Hashtable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.qq.map.qqappointment.exception.QQAppointmentException;

/**
 *系统配置信息类
 * @author 张广
 */
public class QQAppointmentConfig {

    public static Hashtable<String, DaoConfig> beans;

    /**
     * 构造函数
     */
    public QQAppointmentConfig() {
        beans = new Hashtable<String, DaoConfig>();
    }

    /**
     * 增加一个BeanConfig对象
     * @param bean
     */
    public void addDao(DaoConfig bean) {
        beans.put(bean.getId(), bean);
    }

    /**
     * 得到一个DAO接口对象的实例
     * @param name DAO接口对象的名称
     * @return 指定DAO接口的实现类的实例
     */
    public Object getDao(String name) {
        DaoConfig config = beans.get(name);

        if (config == null) {
            throw new QQAppointmentException("Couldn't find the dao: " + name);
        }

        return config.getInstance();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
