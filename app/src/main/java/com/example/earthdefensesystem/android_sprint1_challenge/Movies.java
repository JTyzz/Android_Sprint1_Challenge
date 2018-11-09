package com.example.earthdefensesystem.android_sprint1_challenge;

import java.io.Serializable;

public class  Movies implements Serializable {
    public static final int NO_ID = -1;

    private String title;
    private int id;

    public Movies(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Movies(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }
}
