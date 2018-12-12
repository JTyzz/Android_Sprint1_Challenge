package com.example.earthdefensesystem.android_sprint1_challenge;

import java.io.Serializable;

public class  Movies implements Serializable {
    public static final int NO_ID = -1;

    private String title;
    private int id;
    private boolean watched;

    public Movies(int id, String title, Boolean watched) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setWatched(Boolean watched){
       this.watched = watched;
    }
    public boolean getWatched(){
        return watched;
    }
}
