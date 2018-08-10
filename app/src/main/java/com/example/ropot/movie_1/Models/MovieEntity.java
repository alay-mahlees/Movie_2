package com.example.ropot.movie_1.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import java.util.List;

@Entity(tableName = "moviesdetails")
public class MovieEntity {


    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieRelease() {
        return movieRelease;
    }

    public void setMovieRelease(String movieRelease) {
        this.movieRelease = movieRelease;
    }

    public Double getMovieVote() {
        return movieVote;
    }

    public void setMovieVote(Double movieVote) {
        this.movieVote = movieVote;
    }


    public String getMovieKey() {
        return movieKey;
    }

    public void setMovieKey(String movieKey) {
        this.movieKey = movieKey;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private int movieID;

    @ColumnInfo
    private String movieName;

    @ColumnInfo
    private String movieRelease;

    @ColumnInfo
    private Double movieVote;

    @ColumnInfo
    private String movieKey;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;


}
