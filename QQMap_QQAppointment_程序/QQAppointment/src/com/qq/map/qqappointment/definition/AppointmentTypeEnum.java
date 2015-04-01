/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.definition;


/**
 *
 * @author 张广
 */
public enum AppointmentTypeEnum {
    Dating("Dating"), // 男女约会
    Party("Party"), //聚会
    Discussion("Discussion"), //讨论 
    Meeting("Meeting"), //会议
    Activity("Activity");//活动
    private String value;

    AppointmentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static AppointmentTypeEnum getCaseTypeByValue(String value) {
        return valueOf(value);
    }

    public static String getShortTypeByValue(String value) {
        switch (valueOf(value)) {
            case Dating:
                return "约";
            case Party:
                return "聚";
            case Discussion:
                return "讨";
            case Meeting:
                return "会";
            case Activity:
                return "活";
            default:
                return "未";
        }
    }
}
