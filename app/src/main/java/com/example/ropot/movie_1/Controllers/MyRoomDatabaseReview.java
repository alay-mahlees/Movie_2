package com.example.ropot.movie_1.Controllers;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ropot.movie_1.Models.MovieEntity;
import com.example.ropot.movie_1.Models.MovieEntityReviews;

@Database(entities = {MovieEntityReviews.class, MovieEntity.class}, version = 1, exportSchema = false)
public abstract class MyRoomDatabaseReview extends RoomDatabase {
    public abstract DaoInterfaceReviews daoInterfaceReviews();
}
