/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.definition;

/**
 *
 * @author 张广
 */
public enum AppointmentStatusEnum {
    NotBegin(1), //尚未开始
    OnGoing(2), //进行中
    Finished(3); //已结束
    private int value;

    AppointmentStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static AppointmentStatusEnum getCaseTypeByValue(int value) {
        switch (value) {
            case 1:
                return NotBegin;
            case 2:
                return OnGoing;
            case 3:
                return Finished;
            default:
                return null;
        }
    }
}
