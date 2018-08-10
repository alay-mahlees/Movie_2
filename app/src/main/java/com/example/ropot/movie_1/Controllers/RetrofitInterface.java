package com.example.ropot.movie_1.Controllers;

import com.example.ropot.movie_1.Models.MovieDetails;
import com.example.ropot.movie_1.Models.MovieReviews;
import com.example.ropot.movie_1.Models.MoviesModule;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("/3/movie/{category}")
    Call<MoviesModule> listMovies(@Path("category") String category,
                                  @Query("api_key") String apiKey,
                                  @Query("language") String language,
                                  @Query("page") int page);


    @GET("/3/movie/{movieId}/videos")
    Call<MovieDetails> singleMovie(@Path("movieId") int movieID,
                                   @Query("api_key") String apiKey,
                                   @Query("language") String language);

    @GET("/3/movie/{movieId}/reviews")
    Call<MovieReviews> reviewsMovie(@Path("movieId") int movieID,
                                    @Query("api_key") String apiKey,
                                    @Query("language") String language,
                                    @Query("page") int page);

}
