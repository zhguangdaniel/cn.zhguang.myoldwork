/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 *
 * @author 张广
 */
public class BaseModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6565359673681349447L;

    /**
     * The identify of the object
     */
    private String            id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Common implement equals method
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof BaseModel))
            return false;

        BaseModel target = (BaseModel) obj;

        if (this.getId() != null && this.getId().length() > 0) {
            return this.getId().equals(target.getId());
        }

        if (target.getId() != null && target.getId().length() > 0) {
            return false;
        }

        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /**
     * Generate the hash code
     */
    @Override
    public int hashCode() {
        if (this.getId() != null && this.getId().length() > 0) {
            return this.getId().hashCode();
        }

        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * Common implement toString method
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
