package com.ariemay.filmcategory_submission1_made;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.MoviesAdapter;
import models.Movies;

public class MainActivity extends AppCompatActivity {

    private String[] moviesName;
    private String[] moviesDate;
    private TypedArray moviesPoster;
    private MoviesAdapter adapter;
    private ArrayList<Movies> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MoviesAdapter(this);
        ListView listView = findViewById(R.id.film_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < moviesName.length; i++) {
            Movies movie = new Movies();
            movie.setName(moviesName[i]);
            movie.setDate(moviesDate[i]);
            movie.setPhoto(moviesPoster.getResourceId(i, -1));
            movies.add(movie);
        }

        adapter.setMovies(movies);
    }

    private void prepare() {
        moviesName = getResources().getStringArray(R.array.movie_name);
        moviesDate = getResources().getStringArray(R.array.movies_date);
        moviesPoster = getResources().obtainTypedArray(R.array.data_photo);
    }
}
