/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.digester.Digester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.qq.map.qqappointment.config.QQAppointmentConfig;

/**
 * DAO工厂类还负责读取配置文件
 *  @author 张广
 */
public class DAOFactory {

    private static Logger                   log = LoggerFactory.getLogger(DAOFactory.class);

    // 全局的配置信息对象
    public static final QQAppointmentConfig qqConfig;

    // 进行XML文件向Java对象的转换
    static {
        Digester digester = new Digester();
        digester.setValidating(false);

        // 设置处理规则
        digester.addObjectCreate("config", "com.qq.map.qqappointment.config.QQAppointmentConfig");
        digester.addSetProperties("config");

        digester.addObjectCreate("config/dao", "com.qq.map.qqappointment.config.DaoConfig");
        digester.addSetProperties("config/dao");
        digester.addSetNext("config/dao", "addDao", "com.qq.map.qqappointment.config.DaoConfig");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream("QQAppointmentConfig.xml");
        QQAppointmentConfig config = null;
        try {
            if (in != null)
                config = (QQAppointmentConfig) digester.parse(in);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        qqConfig = config;
    }

    // 取得DAO的实例
    public static Object getDao(String name) {
        if (null == qqConfig)
            return null;

        if (log.isInfoEnabled()) {
            log.info("Getting the dao:" + name);
        }

        return qqConfig.getDao(name);
    }

    public static IUserDAO getUserDAO() {
        log.info("Getting the userDao...");
        return (IUserDAO) getDao("userDao");
    }

    public static IAppointmentDAO getAppointmentDAO() {
        log.info("Getting the appointmentDao...");
        return (IAppointmentDAO) getDao("appointmentDao");
    }

    public static ICommentDAO getCommentDAO() {
        log.info("Getting the commentDao...");
        return (ICommentDAO) getDao("appointmentDao");
    }

    public static IResourceDAO getResourceDAO() {
        log.info("Getting the resourceDao...");
        return (IResourceDAO) getDao("resourceDao");
    }
}
