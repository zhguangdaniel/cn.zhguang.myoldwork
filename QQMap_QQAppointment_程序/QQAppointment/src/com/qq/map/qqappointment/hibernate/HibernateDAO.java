/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * 使用Hibernate实现DAO的基类
 * 包括了持久化操作的一些基础方法
 *  @author 张广
 */
public class HibernateDAO {

    public Session getCurrentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     * 保存对象信息到数据库
     * @param obj 需要进行持久化操作的对象
     */
    public void saveObject(Object obj) {
        getCurrentSession().save(obj);
    }

    /**
     * 更新持久化对象
     * @param obj 需要更新的对象
     */
    public void updateObject(Object obj) {
        getCurrentSession().update(obj);
    }

    /**
     * 使用HQL语句进行查询
     * @param hsql 查询语句
     * @return 符合条件的对象集合
     */
    public List<?> getObjects(String hsql) {
        List<?> result = getCurrentSession().createQuery(hsql).list();
        return result;
    }

    /**
     * 使用HQL语句进行查询
     * @param hsql 查询语句
     * @return 符合条件的对象集合
     */
    public List<?> getTopObjects(String hsql, int top) {
        Query q = getCurrentSession().createQuery(hsql);
        q.setFirstResult(0);
        q.setMaxResults(top);
        return q.list();
    }

    /**
     * 使用HQL语句进行对象的查询
     * @param hsql 查询语句
     * @return 符合条件的对象
     */
    public Object getObject(String hsql) {
        Object result = getCurrentSession().createQuery(hsql).uniqueResult();
        return result;
    }

    /**
     * 根据ID值得到持久化的对象
     * @param cls 对象的类型
     * @param id ID值
     * @return 指定ID的对象
     */
    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> cls, String id) {
        Object result = getCurrentSession().get(cls, id);
        return (T) result;
    }

    /**
     * 删除对象信息
     * @param obj 被删除的对象
     */
    public void deleteObject(Object obj) {
        getCurrentSession().delete(obj);
    }
}
