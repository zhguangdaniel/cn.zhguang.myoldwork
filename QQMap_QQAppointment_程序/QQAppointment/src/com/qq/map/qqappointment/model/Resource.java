/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.model;

import java.util.Date;

/**
 *
 * @author 张广
 */
public class Resource extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = -5528352540382156734L;

    private String            resourceName;

    private Appointment       orgAppointment;

    private String            resourceUri;

    private String            type;

    private long              size;

    private Date              uploadtime;

    private String            introduction;

    private User              creator;

    public Resource() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the resourceName
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName the resourceName to set
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return the resourceUri
     */
    public String getResourceUri() {
        return resourceUri;
    }

    /**
     * @param resourceUri the resourceUri to set
     */
    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return the introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction the introduction to set
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return the uploadtime
     */
    public Date getUploadtime() {
        return uploadtime;
    }

    /**
     * @param uploadtime the uploadtime to set
     */
    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    /**
     * @return the orgAppointment
     */
    public Appointment getOrgAppointment() {
        return orgAppointment;
    }

    /**
     * @param orgAppointment the orgAppointment to set
     */
    public void setOrgAppointment(Appointment orgAppointment) {
        this.orgAppointment = orgAppointment;
    }

    /**
     * @return the creator
     */
    public User getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }
}
