package com.example.ropot.movie_1.Controllers;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ropot.movie_1.Models.MovieEntity;
import com.example.ropot.movie_1.Models.MovieEntityReviews;

import java.util.List;

@Dao
public interface DaoInterface {

    @Insert
    public void saveFavorite(MovieEntity movieEntity);

    @Query("select * from moviesdetails")
    public List<MovieEntity> getFavorite();

    @Delete
    public void deleteFavorite(MovieEntity movieEntity);
}

