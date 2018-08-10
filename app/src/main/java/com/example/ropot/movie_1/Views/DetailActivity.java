package com.example.ropot.movie_1.Views;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.ropot.movie_1.BuildConfig;
import com.example.ropot.movie_1.Controllers.MyRoomDataBase;
import com.example.ropot.movie_1.Controllers.MyRoomDatabaseReview;
import com.example.ropot.movie_1.Controllers.RetrofitInterface;
import com.example.ropot.movie_1.Models.MovieDetails;
import com.example.ropot.movie_1.Models.MovieEntity;
import com.example.ropot.movie_1.Models.MovieEntityReviews;
import com.example.ropot.movie_1.Models.MovieKey;
import com.example.ropot.movie_1.Models.MovieReviews;
import com.example.ropot.movie_1.R;
import com.example.ropot.movie_1.databinding.ActivityDetailBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;


import java.io.ByteArrayOutputStream;
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
import static com.example.ropot.movie_1.Views.MainActivity.listOfResults;


public class DetailActivity extends Activity {


    RetrofitInterface retrofitInterfaceInstance;
    public static final String API_KEY = BuildConfig.ApiKey;

    List<MovieDetails.ResultsBean> catchResult;
    private int movieID;
    private int position;
    public List<MovieDetails.ResultsBean> movieKeys;
    public MovieDetails movieDetails;
    public String holderKey;
    public MovieKey myMovieKey;
    String test;
    List<String> reviewAuthor;
    List<String> reviewContent;
    Bitmap bitmap;
    Bundle bundle;
    String title;
    String overView;
    String release;
    Double voteAverage;
    MovieReviews movieReviews;
    public List<MovieReviews.ResultsBean> resultsBeanList;
    ActivityDetailBinding mBinding = null;

    MovieEntity movieEntity;
    MovieEntityReviews movieEntityReviews;


    public static MyRoomDataBase myRoomDataBase;
    public static MyRoomDatabaseReview myRoomDatabaseReview;


    //CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        catchResult = new ArrayList<>();
        movieKeys = new  ArrayList<>();
        movieDetails = new MovieDetails();
        myMovieKey = new MovieKey();
        test = new String();
        bundle = new Bundle();
        reviewAuthor = new ArrayList<>();
        reviewContent = new ArrayList<>();


        myRoomDataBase = Room.databaseBuilder(getApplicationContext(), MyRoomDataBase.class, "moviesdetails")
                .allowMainThreadQueries().build();

        myRoomDatabaseReview = Room.databaseBuilder(getApplicationContext(), MyRoomDatabaseReview.class, "moviesdetailsreviews")
                .allowMainThreadQueries().build();


        //setContentView(R.layout.activity_detail);



        Retrofit myRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        retrofitInterfaceInstance = myRetrofit.create(RetrofitInterface.class);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        position = getIntent().getIntExtra(String.valueOf(R.string.position), 0);


        String url = getString(R.string.poster_base_path) + listOfResults.get(position).getPoster_path();
        Uri uri = Uri.parse(url);

        //Toast.makeText(DetailActivity.this, url, Toast.LENGTH_LONG).show();

        movieID = listOfResults.get(position).getId();



        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCall();

            }
        });


        mBinding.watchTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calling();

            }
        });

        title = listOfResults.get(position).getTitle();
        overView = listOfResults.get(position).getOverview();
        release = listOfResults.get(position).getRelease_date();
        voteAverage = listOfResults.get(position).getVote_average();


        mBinding.originalTitle.setText(title);
        mBinding.overview.setText(overView);
        mBinding.releaseDate.setText(release);
        mBinding.voteAverage.setText(Double.toString(voteAverage));
        //mBinding.thumbnail.setImageURI(uri);

        Picasso.get().load(uri).into(mBinding.thumbnail);


        /*SharedPreferences sharedPreferences = getSharedPreferences("inputCheck", 0);
        final SharedPreferences.Editor editor = sharedPreferences.edit();*/



        //mBinding.favoritestar.setChecked(sharedPreferences.getBoolean("favoritestar", false));


        final List<MovieEntity> checkMovieEntity = DetailActivity.myRoomDataBase.daoInterface().getFavorite();
        final List<MovieEntityReviews> checkMovieEntityReviews = DetailActivity.myRoomDatabaseReview.daoInterfaceReviews().getReviews();
        for(int s=0; s<checkMovieEntity.size(); s++){
            if(checkMovieEntity.get(s).getMovieID() == movieID){
                mBinding.favoritestar.setChecked(true);
            }
        }

        mBinding.favoritestar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                if(mBinding.favoritestar.isChecked()){
                    /*boolean saveStareValue = mBinding.favoritestar.isChecked();
                    editor.putBoolean("favoritestar", saveStareValue);
                    editor.commit();*/

                    CallReviews();




                    movieEntity = new MovieEntity();
                    movieEntity.setMovieID(movieID);
                    movieEntity.setMovieName(title);
                    movieEntity.setMovieRelease(release);
                    movieEntity.setMovieVote(voteAverage);
                    movieEntity.setImage(getBytesFromBitmap(((BitmapDrawable) mBinding.thumbnail.getDrawable()).getBitmap()));


                    DetailActivity.myRoomDataBase.daoInterface().saveFavorite(movieEntity);

                    for(int i=0; i<reviewAuthor.size(); i++){
                        movieEntityReviews = new MovieEntityReviews();
                        movieEntityReviews.setAuthorName(reviewAuthor.get(i));
                        movieEntityReviews.setContent(reviewContent.get(i));
                        DetailActivity.myRoomDatabaseReview.daoInterfaceReviews().saveReviews(movieEntityReviews);
                    }

                    Toast.makeText(DetailActivity.this, "Checked", Toast.LENGTH_LONG).show();




                }else {

                try {

                    for (int a = 0; a < checkMovieEntity.size(); a++) {

                        if (checkMovieEntity.get(a).getMovieID() == movieID) {

                            MovieEntity movieEntity2 = new MovieEntity();
                            movieEntity2.setId(checkMovieEntity.get(a).getId());
                            DetailActivity.myRoomDataBase.daoInterface().deleteFavorite(movieEntity2);

                            Toast.makeText(DetailActivity.this, "Removed", Toast.LENGTH_LONG).show();
                        }

                    }

                }catch (Exception e){
                    Toast.makeText(DetailActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

                }
            }
        });





    }



    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("m", movieID);

    }*/

    public void  intentCall(){




        Intent intent = new Intent(DetailActivity.this, ReviewPopUp.class);
        intent.putExtra("m", movieID);
        startActivity(intent);
    }

    public void CallReviews(){
        Call<MovieReviews> call = retrofitInterfaceInstance.reviewsMovie(movieID, API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<MovieReviews>() {
            @Override
            public void onResponse(Call<MovieReviews> call, Response<MovieReviews> response) {

                movieReviews = response.body();
                resultsBeanList = movieReviews.getResults();
                for(int i=0; i<resultsBeanList.size(); i++){
                    String holderAuthor = resultsBeanList.get(i).getAuthor();
                    String holderContent = resultsBeanList.get(i).getContent();
                    reviewAuthor.add(holderAuthor);
                    reviewContent.add(holderContent);
                }


            }

            @Override
            public void onFailure(Call<MovieReviews> call, Throwable t) {

            }
        });
    }

    public void Calling() {



        Call<MovieDetails> call = retrofitInterfaceInstance.singleMovie(movieID, API_KEY, LANGUAGE);
        call.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                if (response.isSuccessful()) {

                    try {
                        movieDetails = response.body();



                        movieKeys = movieDetails.getResults();



                        test = movieKeys.get(0).getKey();

                        Toast.makeText(DetailActivity.this, "Call toast: " + test, Toast.LENGTH_LONG).show();






                        //Toast.makeText(DetailActivity.this, movieKey, Toast.LENGTH_LONG).show();


                    } catch (Exception t) {
                        Toast.makeText(DetailActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }


                } else {
                    try {
                        Toast.makeText(DetailActivity.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                if (t instanceof IOException) {
                    Toast.makeText(DetailActivity.this, "Connection error", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DetailActivity.this, "Error is: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        Intent intent = new Intent(DetailActivity.this, WatchTrailer.class);

        intent.putExtra("m", movieID);

        startActivity(intent);

    }

    public void SaveFavorite(View view) {
    }

    public byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }
}
