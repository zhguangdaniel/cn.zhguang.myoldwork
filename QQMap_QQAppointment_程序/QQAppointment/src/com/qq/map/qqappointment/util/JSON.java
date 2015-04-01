/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.map.qqappointment.servlet.HibernateFilter;

/**
 *
 * @author 张广
 */
public class JSON {
    private static Logger log = LoggerFactory.getLogger(HibernateFilter.class);

    public static JSONObject put(JSONObject json, String key, String value) {
        try {
            json.put(key, value);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            log.error(e.getLocalizedMessage());
        }
        return json;
    }
}
