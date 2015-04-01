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

/**
 *
 * @author 张广
 */
public class EncodingFilter implements Filter {

    private String targetEncoding = "utf-8";

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
            ServletException {
        req.setCharacterEncoding(targetEncoding);
        resp.setCharacterEncoding(targetEncoding);
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        String initEncoding = config.getInitParameter("encoding");
        if (initEncoding != null && !initEncoding.equals(""))
            this.targetEncoding = config.getInitParameter("encoding");
    }

}
