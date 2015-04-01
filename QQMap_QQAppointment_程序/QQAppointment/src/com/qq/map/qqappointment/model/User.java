/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.model;

import java.util.Set;

/**
 *
 * @author 张广
 */
public class User extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = -7215720458239488485L;

    private String            nickName;

    private String            userName;

    private String            password;

    private String            iconUrl;

    private String            location;

    private String            phone;

    private String            email;

    private String            longitude;

    private String            latitude;

    private String            keyWords;

    private Set<Appointment>  createdAppointments;

    private Set<Resource>     createdResources;

    private Set<Comment>      createdComments;

    private Set<Appointment>  canAttendAppointments;

    public User() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the createdAppointments
     */
    public Set<Appointment> getCreatedAppointments() {
        return createdAppointments;
    }

    /**
     * @param createdAppointments the createdAppointments to set
     */
    public void setCreatedAppointments(Set<Appointment> createdAppointments) {
        this.createdAppointments = createdAppointments;
    }

    /**
     * @return the createdResources
     */
    public Set<Resource> getCreatedResources() {
        return createdResources;
    }

    /**
     * @param createdResources the createdResources to set
     */
    public void setCreatedResources(Set<Resource> createdResources) {
        this.createdResources = createdResources;
    }

    /**
     * @return the createdComments
     */
    public Set<Comment> getCreatedComments() {
        return createdComments;
    }

    /**
     * @param createdComments the createdComments to set
     */
    public void setCreatedComments(Set<Comment> createdComments) {
        this.createdComments = createdComments;
    }

    /**
     * @return the canAttendAppointments
     */
    public Set<Appointment> getCanAttendAppointments() {
        return canAttendAppointments;
    }

    /**
     * @param canAttendAppointments the canAttendAppointments to set
     */
    public void setCanAttendAppointments(Set<Appointment> canAttendAppointments) {
        this.canAttendAppointments = canAttendAppointments;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the keyWords
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * @param keyWords the keyWords to set
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

}
