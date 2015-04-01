/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.model;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author 张广
 */
public class Comment extends BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = 5482783663825716197L;

    private Appointment       orgAppointment;

    private User              creator;

    /**
     * 对回复的回复
     */
    private Comment           parentComment;

    private Set<Comment>      subComments;

    private String            content;

    private Date              createTime;

    private Date              modifyTime;

    public Comment() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime the modifyTime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    /**
     * @return the parentComment
     */
    public Comment getParentComment() {
        return parentComment;
    }

    /**
     * @param parentComment the parentComment to set
     */
    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    /**
     * @return the subComments
     */
    public Set<Comment> getSubComments() {
        return subComments;
    }

    /**
     * @param subComments the subComments to set
     */
    public void setSubComments(Set<Comment> subComments) {
        this.subComments = subComments;
    }
}
