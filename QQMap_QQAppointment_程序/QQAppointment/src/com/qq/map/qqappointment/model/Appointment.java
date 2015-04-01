/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 张广
 */
public class Appointment extends BaseModel {
    /**
     * 
     */
    private static final long serialVersionUID = -6169492476991189370L;

    private String            title;

    /**
     * 约会，聚会，讨论，会议
     */
    private String            type;

    private int               attendeeCount;

    private int               attendeeLimited;

    private Date              startTime;

    private Date              endTime;

    private String            address;

    private String            longitude;

    private String            latitude;

    private String            introduction;

    private String            iconUrl;

    private String            appImageUrl;

    /**
     * user, 外键
     */
    private User              creator;

    /**
     * 参加方式有下面三种：<br/>
     * 1，开放式（所有人都能参加）;<br/>
     * 2，审批式（自己申请，批准才能参加）;<br/>
     * 3，邀请式（邀请指定的人参加）;
     */
    private int               attendType;

    /**
     * Appointment的状态分三种：<br/>
     * 1，尚未进行;<br/>
     * 2，进行中;<br/>
     * 3，已结束;
     */
    private int               status;

    private Set<Resource>     resources        = new HashSet<Resource>(0);

    private Set<Comment>      comments         = new HashSet<Comment>(0);

    private Set<User>         attendees        = new HashSet<User>(0);

    public Appointment() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
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
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the attendeeCount
     */
    public int getAttendeeCount() {
        return attendeeCount;
    }

    /**
     * @param attendeeCount the attendeeCount to set
     */
    public void setAttendeeCount(int attendeeCount) {
        this.attendeeCount = attendeeCount;
    }

    /**
     * @return the attendeeLimited
     */
    public int getAttendeeLimited() {
        return attendeeLimited;
    }

    /**
     * @param attendeeLimited the attendeeLimited to set
     */
    public void setAttendeeLimited(int attendeeLimited) {
        this.attendeeLimited = attendeeLimited;
    }

    /**
     * @return the attendType
     */
    public int getAttendType() {
        return attendType;
    }

    /**
     * @param attendType the attendType to set
     */
    public void setAttendType(int attendType) {
        this.attendType = attendType;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
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

    /**
     * @return the resources
     */
    public Set<Resource> getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    /**
     * @return the comments
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @return the attendees
     */
    public Set<User> getAttendees() {
        return attendees;
    }

    /**
     * @param attendees the attendees to set
     */
    public void setAttendees(Set<User> attendees) {
        this.attendees = attendees;
    }

    /**
     * @return the iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * @param iconUrl the iconUrl to set
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * @return the appImageUrl
     */
    public String getAppImageUrl() {
        return appImageUrl;
    }

    /**
     * @param appImageUrl the appImageUrl to set
     */
    public void setAppImageUrl(String appImageUrl) {
        this.appImageUrl = appImageUrl;
    }
}
