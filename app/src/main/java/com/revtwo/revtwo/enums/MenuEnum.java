package com.revtwo.revtwo.enums;

/**
 * Created by NIHAD on 10.2.2016.
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
