package com.revtwo.revtwo.models;

/*
 *  MenuItem.java
 *  RevTwo-Sample-App
 *
 *  Created on 2/13/2016.
 *  Copyright (c) 2015-2019 RevTwo, Inc. All rights reserved.
 */
public class MenuItem {
    private int id;
    private String title;

    public MenuItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
