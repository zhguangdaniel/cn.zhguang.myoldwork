/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.qq.map.qqappointment.hibernate.HibernateDAO;
import com.qq.map.qqappointment.model.Comment;

/**
 *
 * @author 张广
 */
public class CommentDAO extends HibernateDAO implements ICommentDAO {

    @Override
    public Comment getCommentById(String id) {
        // TODO Auto-generated method stub
        return getObject(Comment.class, id);
    }

    @Override
    public void save(Comment cmt) {
        // TODO Auto-generated method stub
        if (cmt == null)
            return;

        //        Comment u = getCommentById(cmt.getId());
        //        if (u != null)
        //            throw new DAOException("评论已经存在，请重新评论！");

        saveObject(cmt);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Comment> getRealTimeAppointmentComments(String appointID, String lastTime) {

        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;

        try {
            date1 = DateFormat.parse(lastTime);

        } catch (Exception e) {
            return null;
        }

        String hsqlString = " select c from Comment as c join c.orgAppointment as a where c.createTime>= " + date1
                + " and a.id = '" + appointID + "'";

        return (List<Comment>) getObjects(hsqlString);
    }

    @Override
    public void delete(String commentId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Comment cmt) {
        // TODO Auto-generated method stub

    }

}
