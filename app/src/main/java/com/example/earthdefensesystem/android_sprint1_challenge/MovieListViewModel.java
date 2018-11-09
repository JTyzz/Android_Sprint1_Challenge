package com.example.earthdefensesystem.android_sprint1_challenge;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class MovieListViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Movies>> overviewList;

    public LiveData<ArrayList<Movies>> getOverViewList() {
        if (overviewList == null) {
            loadList();
        }
        return overviewList;
    }
    private void loadList() {
        overviewList = MovieListRepo.getOverviewList();
    }

}
