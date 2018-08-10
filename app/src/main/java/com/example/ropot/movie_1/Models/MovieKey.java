package com.example.ropot.movie_1.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieKey implements Parcelable {

    public String movieKey;

    public MovieKey(Parcel in) {
        movieKey = in.readString();
    }

    public static final Creator<MovieKey> CREATOR = new Creator<MovieKey>() {
        @Override
        public MovieKey createFromParcel(Parcel in) {
            return new MovieKey(in);
        }

        @Override
        public MovieKey[] newArray(int size) {
            return new MovieKey[size];
        }
    };

    public MovieKey() {

    }

    public String getMovieKey() {
        return movieKey;
    }

    public void setMovieKey(String movieKey) {
        this.movieKey = movieKey;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieKey);
    }
}
