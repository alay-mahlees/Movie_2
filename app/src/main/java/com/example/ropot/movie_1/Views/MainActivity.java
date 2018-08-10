package com.example.ropot.movie_1.Views;

import android.arch.persistence.room.Room;
import android.content.AsyncTaskLoader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ropot.movie_1.BuildConfig;
import com.example.ropot.movie_1.Controllers.FavoritePosterAdapter;
import com.example.ropot.movie_1.Controllers.MyRoomDataBase;
import com.example.ropot.movie_1.Controllers.MyRoomDatabaseReview;
import com.example.ropot.movie_1.Controllers.PosterAdapter;
import com.example.ropot.movie_1.Controllers.RetrofitInterface;
import com.example.ropot.movie_1.Models.MovieEntity;
import com.example.ropot.movie_1.Models.MoviesModule;
import com.example.ropot.movie_1.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.ropot.movie_1.Models.Constant.BASE_URL;
import static com.example.ropot.movie_1.Models.Constant.LANGUAGE;
import static com.example.ropot.movie_1.Models.Constant.PAGE;

public class MainActivity extends FragmentActivity {

    public static final String API_KEY = BuildConfig.ApiKey;
    public String category;

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    public static List<MoviesModule.ResultsBean> listOfResults;
    ArrayList<String> myList;
    PosterAdapter posterAdapter;
    RetrofitInterface retrofitInterfaceInstance;
    public static MyRoomDataBase myRoomDataBase;
    public static MyRoomDatabaseReview myRoomDatabaseReview;
    ArrayList<byte[]> imageByte;
    public static FavoritePosterAdapter favoritePosterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);

        gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

        category = new String("popular");

        imageByte = new ArrayList<>();

        Retrofit myRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        retrofitInterfaceInstance = myRetrofit.create(RetrofitInterface.class);

        queryString(category);

        myRoomDataBase = Room.databaseBuilder(getApplicationContext(), MyRoomDataBase.class, "moviesdetails")
                .allowMainThreadQueries().build();

        myRoomDatabaseReview = Room.databaseBuilder(getApplicationContext(), MyRoomDatabaseReview.class, "moviesdetailsreviews")
                .allowMainThreadQueries().build();

        getFavoriteList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.popular:

                queryString("popular");

                return true;

            case R.id.top_rated:
                queryString("top_rated");
                return true;

            case R.id.favorite:

                favoritePosterAdapter = new FavoritePosterAdapter(MainActivity.this, imageByte);
                recyclerView.setAdapter(favoritePosterAdapter);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void getFavoriteList() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                List<MovieEntity> movieEntities = MainActivity.myRoomDataBase.daoInterface().getFavorite();


                for (int i = 0; i < movieEntities.size(); i++) {

                    byte[] imageHolder = movieEntities.get(i).getImage();

                    imageByte.add(imageHolder);
                }
            }
        }).start();


    }


    public void queryString(String mCategory) {

        myList.clear();

        Call<MoviesModule> call = retrofitInterfaceInstance.listMovies(mCategory, API_KEY, LANGUAGE, PAGE);

        call.enqueue(new Callback<MoviesModule>() {
            @Override
            public void onResponse(Call<MoviesModule> call, Response<MoviesModule> response) {

                if (response.isSuccessful()) {


                    MoviesModule catchRespons = response.body();
                    listOfResults = catchRespons.getResults();
                    Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();


                    for (int i = 0; i < listOfResults.size(); i++) {

                        String posterPath = listOfResults.get(i).getPoster_path();
                        myList.add(posterPath);


                    }
                    posterAdapter = new PosterAdapter(MainActivity.this, myList);
                    recyclerView.setAdapter(posterAdapter);


                } else {

                    try {
                        Toast.makeText(MainActivity.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure(Call<MoviesModule> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(MainActivity.this, "Network error", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Other error: : " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        return;
    }

}
