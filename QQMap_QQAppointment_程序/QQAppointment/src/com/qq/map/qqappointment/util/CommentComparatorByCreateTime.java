/*
 * Copyright (c) 2011 by Guoqiang Yu, all rights reserved.
 */

package com.qq.map.qqappointment.util;

import java.util.Comparator;

import com.qq.map.qqappointment.model.Comment;

/**
 *
 * @author Guoqiang Yu
 */
public class CommentComparatorByCreateTime implements Comparator {

    public int compare(Object o1, Object o2) {
        // TODO Auto-generated method stub
        Comment c1 = (Comment) o1;
        Comment c2 = (Comment) o2;
        if (c1.getCreateTime().after(c2.getCreateTime())) {
            return -1;
        } else {
            if (c1.getCreateTime().before(c2.getCreateTime())) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
