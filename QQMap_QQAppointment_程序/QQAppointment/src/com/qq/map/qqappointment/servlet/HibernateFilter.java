/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.map.qqappointment.hibernate.HibernateUtil;

/**
 * 用于进行Hibernate事务处理的Servlet过滤器
 *
 * @author 张广
 */
public class HibernateFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(HibernateFilter.class);

    /**
     * 过滤器的主要方法
     * 用于实现Hibernate事务的开始和提交
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        // 得到SessionFactory对象的实例
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try {
            // 开始一个新的事务
            log.debug("Starting a database transaction");
            sf.getCurrentSession().beginTransaction();

            log.debug("Request Path:\t" + ((HttpServletRequest) request).getServletPath());
            // Call the next filter (continue request processing)
            chain.doFilter(request, response);

            // 提交事务
            log.debug("Committing the database transaction");
            sf.getCurrentSession().getTransaction().commit();

        } catch (Throwable ex) {
            ex.printStackTrace();
            try {
                // 回滚事务
                log.debug("Trying to rollback database transaction after exception");
                sf.getCurrentSession().getTransaction().rollback();
            } catch (Throwable rbEx) {
                log.error("Could not rollback transaction after exception!", rbEx);
            }

            // 抛出异常
            throw new ServletException(ex);
        }
    }

    /**
     * Servlet过滤器的初始化方法
     * 可以读取配置文件中设置的配置参数
     */
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Servlet的销毁方法
     * 用于释放过滤器所申请的资源
     */
    public void destroy() {
    }
}
