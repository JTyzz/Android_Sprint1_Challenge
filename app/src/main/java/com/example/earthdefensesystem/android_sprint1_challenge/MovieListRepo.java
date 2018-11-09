package com.example.earthdefensesystem.android_sprint1_challenge;

import android.arch.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieListRepo implements Serializable {
    public static MutableLiveData<ArrayList<Movies>> getOverviewList () {
        final MutableLiveData<ArrayList<Movies>> liveDataList = new MutableLiveData<>();
//        ArrayList<Movies> overviews = Movies.getTitle();
//        liveDataList.setValue(overviews);
        return liveDataList;
    }
}
