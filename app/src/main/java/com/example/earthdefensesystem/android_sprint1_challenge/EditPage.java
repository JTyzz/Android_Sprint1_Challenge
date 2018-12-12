package com.example.earthdefensesystem.android_sprint1_challenge;


import android.app.Activity;
import android.graphics.Paint;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;


public class EditPage extends AppCompatActivity {

    public static final String EDIT_MOVIE_KEY = "edit_movie";

    Switch watchedButton;
    Button saveButton, deleteButton;
    EditText editMovie;
    Context context;
    Movies movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);

        editMovie = findViewById(R.id.edit_movie);
        saveButton = findViewById(R.id.save_button);
        deleteButton = findViewById(R.id.delete_button);
        watchedButton = findViewById(R.id.watched_button);


        findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie.setTitle(null);
                Intent resultIntent = new Intent ();
                resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();

            }
        });

        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie.setTitle(editMovie.getText().toString());
                movie.setWatched(watchedButton.isChecked());
                Intent resultIntent = new Intent ();
                resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
                //send to listpage
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

        movie = (Movies) getIntent().getSerializableExtra(EDIT_MOVIE_KEY);
        if(movie == null) {
            movie = new Movies(Movies.NO_ID);
            movie.setWatched(false);
        }
        editMovie.setText(movie.getTitle());
        watchedButton.setChecked(movie.getWatched());
    }

//
//    @Override
//    public void onBackPressed() {
//        prepResult();
//        super.onBackPressed();
//    }
//
//    private void prepResult() {
//        movie.setTitle(editMovie.getText().toString());
//        Intent resultIntent = new Intent ();
//        resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
//        setResult(Activity.RESULT_OK, resultIntent);
//    }
}
