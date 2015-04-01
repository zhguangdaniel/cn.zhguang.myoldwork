/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import java.util.List;

import com.qq.map.qqappointment.model.Comment;

/**
 *
 * @author 张广
 */
public interface ICommentDAO {
    /**
     * 保存Comment对象
     * @param cmt
     */
    public void save(Comment cmt);

    /**
     *  根据Comment ID得到Comment信息
     * @param id
     * @return
     */
    public Comment getCommentById(String id);

    /**
     * 获取指定appointment在lastTime之后最新添加的comments
     * @param appointID
     * @param lastTime
     * @return
     */
    public List<Comment> getRealTimeAppointmentComments(String appointID, String lastTime);

    /**
     * 更新Comment
     * @param cmt
     */
    public void update(Comment cmt);

    /**
     * 删除
     * @param cmtId
     */
    public void delete(String commentId);
}
