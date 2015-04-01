/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import com.qq.map.qqappointment.model.Resource;

/**
 *
 * @author 张广
 */
public interface IResourceDAO {
    /**
     * 保存Resource对象
     * @param res
     */
    public void save(Resource res);

    /**
     *  根据Resource ID得到Resource信息
     * @param id
     * @return
     */
    public Resource getResourceById(String id);

    /**
     * 删除资源
     * @param id
     */
    public void delete(Resource id);
}
