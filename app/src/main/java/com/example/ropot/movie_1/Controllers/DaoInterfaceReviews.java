package com.example.ropot.movie_1.Controllers;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ropot.movie_1.Models.MovieEntityReviews;

import java.util.List;

@Dao
public interface DaoInterfaceReviews{

    @Insert
    public void saveReviews(MovieEntityReviews movieEntityReviews);

    @Query("select * from moviesdetailsreviews")
    public List<MovieEntityReviews> getReviews();

    @Delete
    public void deleteReviews(MovieEntityReviews movieEntityReviews);
}
