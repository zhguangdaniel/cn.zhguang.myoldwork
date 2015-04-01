/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.definition;

/**
 *
 * @author 张广
 */
public enum AttendTypeEnum {
    Open(1), //开放式（所有人都能参加）
    NeedApproval(2), //审批式（自己申请，批准才能参加）
    BeInvited(3), //邀请式（邀请并同意的人参加）
    Limited(4);//限定式（只有限定的人能参加）
    private int value;

    AttendTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static AttendTypeEnum getCaseTypeByValue(int value) {
        switch (value) {
            case 1:
                return Open;
            case 2:
                return NeedApproval;
            case 3:
                return BeInvited;
            case 4:
                return Limited;
            default:
                return null;
        }
    }
}
