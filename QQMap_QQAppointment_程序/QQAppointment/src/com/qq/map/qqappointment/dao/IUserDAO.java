/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import com.qq.map.qqappointment.model.User;

/**
 *
 * @author 张广
 */
public interface IUserDAO {
    /**
     * 保存用户对象
     * @param user
     */
    public void save(User user);

    /**
     *  根据用户ID得到用户信息
     * @param id
     * @return
     */
    public User getUserById(String id);

    /**
     *  根据用户user name得到用户信息
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName);

    /**
     * 更新用户信息
     * @param user
     */
    public void update(User user);

    /**
     * 删除用户
     * @param userId
     */
    public void delete(String userId);
}
