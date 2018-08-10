package com.example.ropot.movie_1.Controllers;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import com.example.ropot.movie_1.Models.MovieEntity;

@Database(entities = {MovieEntity.class}, version = 1, exportSchema = false)
public abstract class MyRoomDataBase extends RoomDatabase {

    public abstract DaoInterface daoInterface();


    /*static final Migration migration_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {




        }
    };*/
}
