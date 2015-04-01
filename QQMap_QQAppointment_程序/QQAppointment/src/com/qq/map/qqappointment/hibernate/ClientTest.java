/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qq.map.qqappointment.model.User;

/**
 *
 * @author 张广
 */
public class ClientTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //读取hibernate.cfg.xml文件
        Configuration cfg = new Configuration().configure();

        //创建SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = null;
        try {
            session = factory.openSession();

            //开启事务
            session.beginTransaction();

            User user = new User();
            user.setNickName("张三");
            user.setPassword("123");

            //保存数据
            //session.save(user);

            //            //查询数据
            //            String hql = "from com.qq.map.qqappointment.model.User";
            //            List<User> list = session.createQuery(hql).list();
            //            for (User u : list) {
            //                System.out.println(u.getNickName());
            //            }

            //提交事务
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    //关闭session
                    session.close();
                }
            }
        }

    }
}
