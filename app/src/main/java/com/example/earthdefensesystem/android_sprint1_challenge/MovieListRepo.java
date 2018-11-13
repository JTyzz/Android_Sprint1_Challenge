package com.example.earthdefensesystem.android_sprint1_challenge;

import android.arch.lifecycle.MutableLiveData;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieListRepo implements Serializable {

    private ArrayList<Movies> movies;

    public MovieListRepo(){
        this.movies = new ArrayList<>();
    }


    public MutableLiveData<ArrayList<Movies>> getMovieList() {
        MutableLiveData<ArrayList<Movies>> liveDataList = new MutableLiveData<>();
        liveDataList.setValue(movies);
        return liveDataList;
    }

    public ArrayList<Movies> addMovie(Movies movie) {
        if (movie.getId() == Movies.NO_ID) {
            int movieIndex = movies.size();
            movie.setId(movieIndex);
            movies.add(movie);
        } else {
            movies.set(movie.getId(), movie);
        }
        return movies;
    }
}
