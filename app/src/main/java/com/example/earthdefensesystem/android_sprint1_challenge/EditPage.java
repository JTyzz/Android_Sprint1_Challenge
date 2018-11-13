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


public class EditPage extends AppCompatActivity {

    public static final String EDIT_MOVIE_KEY = "edit_movie";

    FloatingActionButton watchedButton;
    EditText editMovie;
    Context context;
    Movies movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);

        editMovie = findViewById(R.id.edit_movie);
        watchedButton = findViewById(R.id.watched_button);


        findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie.setTitle(null);
                Intent resultIntent = new Intent ();
                resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
                setResult(Activity.RESULT_OK, resultIntent);

            }
        });

        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie.setTitle(editMovie.getText().toString());
                Intent resultIntent = new Intent ();
                resultIntent.putExtra(EDIT_MOVIE_KEY, movie);
                setResult(Activity.RESULT_OK, resultIntent);
//                editMovie.setText("");
            }
        });

//        findViewById(R.id.watched_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!editMovie.getPaint().isStrikeThruText()) {
//                    editMovie.setPaintFlags(editMovie.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//                } else {
//                    editMovie.setPaintFlags(editMovie.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
//                }
//            }
//        });

        movie = (Movies) getIntent().getSerializableExtra(EDIT_MOVIE_KEY);
        if(movie == null) {
            movie = new Movies(Movies.NO_ID);
        }
        editMovie.setText(movie.getTitle());
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
