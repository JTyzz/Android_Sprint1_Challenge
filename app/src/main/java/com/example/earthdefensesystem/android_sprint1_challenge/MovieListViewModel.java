package com.example.earthdefensesystem.android_sprint1_challenge;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class MovieListViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Movies>> movieList;
    private MovieListRepo repo;

    public LiveData<ArrayList<Movies>> getMoviesList() {
        if (movieList == null) {
            loadList();
        }
        return movieList;
    }

    private void loadList() {
        repo = new MovieListRepo();
        movieList = repo.getMovieList();
    }

    public void addMovie(Movies movie) {
        if (movieList != null) {
            movieList.setValue(repo.addMovie(movie));
        }
    }
}
