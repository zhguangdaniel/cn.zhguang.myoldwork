/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import com.qq.map.qqappointment.hibernate.HibernateDAO;
import com.qq.map.qqappointment.model.Resource;

/**
 *
 * @author 张广
 */
public class ResourceDAO extends HibernateDAO implements IResourceDAO {

    @Override
    public Resource getResourceById(String id) {
        // TODO Auto-generated method stub
        return getObject(Resource.class, id);
    }

    @Override
    public void save(Resource res) {
        // TODO Auto-generated method stub
        if (res == null)
            return;

        //        Resource u = getResourceById(res.getId());
        //        if (u != null)
        //            throw new DAOException("资源已经存在，请重新上传！");

        saveObject(res);
    }

    @Override
    public void delete(Resource id) {
        // TODO Auto-generated method stub

    }

}
