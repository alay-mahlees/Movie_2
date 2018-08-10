package com.example.ropot.movie_1.Views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.example.ropot.movie_1.BuildConfig;
import com.example.ropot.movie_1.Controllers.MoviesReviewsAdapter;
import com.example.ropot.movie_1.Controllers.RetrofitInterface;
import com.example.ropot.movie_1.Models.MovieReviews;
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

public class ReviewPopUp extends Activity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    MoviesReviewsAdapter mMoviesReviewsAdapter;
    List<String> authorList;
    List<String> contentList;
    RetrofitInterface mRetroFitInterface;
    public static List<MovieReviews.ResultsBean> listReviews;
    int movieId;

    Call<MovieReviews> call;

    public static final String API_KEY = BuildConfig.ApiKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_pop_up);

        mRecyclerView = findViewById(R.id.recycler_review);





        movieId = getIntent().getIntExtra("m", 0);

        Toast.makeText(ReviewPopUp.this, String.valueOf(movieId), Toast.LENGTH_LONG).show();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8), (int) (height*.8));

        mLinearLayoutManager = new LinearLayoutManager(ReviewPopUp.this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        Retrofit myRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        mRetroFitInterface = myRetrofit.create(RetrofitInterface.class);

        Calling();


    }

    /*@Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        movieId = savedInstanceState.getInt("m");
    }*/

    public void Calling(){

        //myList.clear();
      try {
          call = mRetroFitInterface.reviewsMovie(movieId, API_KEY, LANGUAGE, PAGE);

          call.enqueue(new Callback<MovieReviews>() {
              @Override
              public void onResponse(Call<MovieReviews> call, Response<MovieReviews> response) {
                  if(response.isSuccessful()){
                      MovieReviews movieReviews = response.body();
                      listReviews = movieReviews.getResults();
                      Toast.makeText(ReviewPopUp.this, response.body().toString(), Toast.LENGTH_LONG).show();

                      authorList = new ArrayList<>();
                      contentList = new ArrayList<>();

                      for(int i = 0; i<listReviews.size(); i++){
                          String authorName = listReviews.get(i).getAuthor();
                          String content = listReviews.get(i).getContent();
                          authorList.add(authorName);
                          contentList.add(content);
                          //authorList.set(i, authorName);
                          //contentList.set(i, content);

                          /* holderElement.setAuthor(authorName);
                          holderElement.setContent(content);
                          myList.set(i, holderElement);*/
                      }
                      mMoviesReviewsAdapter = new MoviesReviewsAdapter(ReviewPopUp.this, authorList, contentList);
                      mRecyclerView.setAdapter(mMoviesReviewsAdapter);
                  }else {
                      try {
                          Toast.makeText(ReviewPopUp.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                  }
              }

              @Override
              public void onFailure(Call<MovieReviews> call, Throwable t) {

                  if(t instanceof IOException){
                      Toast.makeText(ReviewPopUp.this, "Network error", Toast.LENGTH_LONG).show();
                  }else {
                      Toast.makeText(ReviewPopUp.this, "Other error: : " + t.getMessage(), Toast.LENGTH_LONG).show();

                  }

              }
          });

      }catch (Exception e){
          Toast.makeText(ReviewPopUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
      }


    }
}
