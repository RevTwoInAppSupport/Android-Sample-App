package com.revtwo.revtwo.enums;

/*
 *  MenuEnum.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/10/2016.
 *  Copyright (c) 2015-2016 RevTwo, Inc. All rights reserved.
 */
public enum MenuEnum {
    LOGGING(1000),
    FILE_BROWSING(1001),
    SQLITE_DATABASE(1002),
    CREATE_NEW_TICKET(1003);
    private int value;
    private MenuEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
