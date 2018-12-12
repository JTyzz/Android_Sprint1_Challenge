package com.example.earthdefensesystem.android_sprint1_challenge;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListPage extends AppCompatActivity {

    private LinearLayout listLayout;
    private Context context;
    ArrayList<Movies> movies;
    MovieListViewModel viewModel;

    public static final int EDIT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        context = this;
        listLayout = findViewById(R.id.list_layout);
        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        final Observer<ArrayList<Movies>> observer = new Observer<ArrayList<Movies>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Movies> movies) {
                if(movies != null) {
                    refreshListView(movies);
                }
            }
        };
        viewModel.getMoviesList().observe(this, observer);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditPage.class);
                Movies newMovie = new Movies(Movies.NO_ID);
                intent.putExtra(EditPage.EDIT_MOVIE_KEY, newMovie);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
            }
        });

}

    private TextView getDefaultTextView(final Movies movies) {
        TextView textView = new TextView(context);
        textView.setText(movies.getTitle());
        textView.setTextSize(24);
        textView.setPadding(12, 12, 12, 12);
        boolean watched = movies.getWatched();
        if (watched)
        {
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditPage.class);
                intent.putExtra(EditPage.EDIT_MOVIE_KEY, movies);
                startActivityForResult(intent, EDIT_REQUEST_CODE);
            }
        });

        return textView;
    }

    private void refreshListView(ArrayList<Movies> movies) {
        listLayout.removeAllViews();
        for (Movies movie : movies) {
            listLayout.addView(getDefaultTextView(movie));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == EDIT_REQUEST_CODE) {
                if (data != null) {
                    Movies returnedMovies = (Movies) data.getSerializableExtra(EditPage.EDIT_MOVIE_KEY);
//
//                    boolean foundMovies = false;
//                    for (int i = 0; i < movies.size(); ++i) {
//                        if (movies.get(i).getId() == returnedMovies.getId()) {
//                            movies.set(i, returnedMovies);
//                            foundMovies = true;
//                        }
//                    }
//                    if (!foundMovies) {
//                        movies.add(returnedMovies);
//                    }
                    viewModel.addMovie(returnedMovies);
                }
            }
        }
    }
}
