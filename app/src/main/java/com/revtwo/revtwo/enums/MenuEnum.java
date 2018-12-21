package com.revtwo.revtwo.enums;

/*
 *  MenuEnum.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/10/2016.
 *  Copyright (c) 2015-2019 RevTwo, Inc. All rights reserved.
 */
public enum MenuEnum {
    LOGGING(1000),
    FILE_BROWSING(1001),
    SQLITE_DATABASE(1002),
    MY_TICKET_VIEW(1003),
    COMMUNITY_VIEW(1004),
    FAQ_VIEW(1005);
    private int value;
    private MenuEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

}
