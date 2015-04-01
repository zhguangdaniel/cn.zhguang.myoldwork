/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import com.qq.map.qqappointment.exception.DAOException;
import com.qq.map.qqappointment.hibernate.HibernateDAO;
import com.qq.map.qqappointment.model.User;

/**
 *
 * @author 张广
 */
public class UserDAO extends HibernateDAO implements IUserDAO {

    @Override
    public User getUserById(String id) {
        // TODO Auto-generated method stub
        return getObject(User.class, id);
    }

    @Override
    public User getUserByUserName(String userName) {
        // TODO Auto-generated method stub
        String hsql = "from User u where u.userName='" + userName + "'";
        return (User) getObject(hsql);
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        if (user == null)
            return;

        User u = getUserByUserName(user.getUserName());
        if (u != null)
            throw new DAOException("用户名已经存在，请使用其他用户名！");

        saveObject(user);
    }

    @Override
    public void delete(String userId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub

    }

}
