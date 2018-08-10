package com.example.ropot.movie_1.Views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.example.ropot.movie_1.BuildConfig;
import com.example.ropot.movie_1.Controllers.RetrofitInterface;
import com.example.ropot.movie_1.Controllers.WatchTrailerPopUpAdapter;
import com.example.ropot.movie_1.Models.MovieDetails;
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

public class WatchTrailer extends Activity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    WatchTrailerPopUpAdapter watchTrailerPopUpAdapter;
    List<String> keyList;
    RetrofitInterface mRetroFitInterface;
    public static List<MovieDetails.ResultsBean> listReviews;
    int movieId;

    Call<MovieDetails> call;


    public static final String API_KEY = BuildConfig.ApiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_trailer);

        mRecyclerView = findViewById(R.id.recycler_trailer);

        keyList = new ArrayList<>();

        movieId = getIntent().getIntExtra("m", 0);

        Toast.makeText(WatchTrailer.this, String.valueOf(movieId), Toast.LENGTH_LONG).show();


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8), (int) (height*.8));

        mLinearLayoutManager = new LinearLayoutManager(WatchTrailer.this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        Retrofit myRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        mRetroFitInterface = myRetrofit.create(RetrofitInterface.class);





        Calling();

    }

    private void Calling() {


        try {
            call = mRetroFitInterface.singleMovie(movieId, API_KEY, LANGUAGE);

            call.enqueue(new Callback<MovieDetails>() {
                @Override
                public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(WatchTrailer.this, response.body().toString(), Toast.LENGTH_LONG).show();
                        MovieDetails movieDetails = response.body();
                        listReviews = movieDetails.getResults();

                        for(int i=0; i<listReviews.size(); i++){
                            String keyMovie = listReviews.get(i).getKey();
                            keyList.add(keyMovie);
                        }




                        watchTrailerPopUpAdapter = new WatchTrailerPopUpAdapter(WatchTrailer.this, keyList);
                        mRecyclerView.setAdapter(watchTrailerPopUpAdapter);


                        }


                    else {
                        try {
                            Toast.makeText(WatchTrailer.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


                @Override
                public void onFailure(Call<MovieDetails> call, Throwable t) {
                    if(t instanceof IOException){
                        Toast.makeText(WatchTrailer.this, "Network error", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(WatchTrailer.this, "Other error: : " + t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }


            });

        }catch (Exception e){
            Toast.makeText(WatchTrailer.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }
    }

