package com.revtwo.revtwo.models;

/**
 * Created by Zajim on 13-Feb-16.
 */
public class MenuItemMainActivity {
    private int id;
    private String title;

    public MenuItemMainActivity(int id, String title) {
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
