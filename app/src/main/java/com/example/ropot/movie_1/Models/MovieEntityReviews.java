package com.example.ropot.movie_1.Models;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "moviesdetailsreviews", foreignKeys = @ForeignKey(entity = MovieEntity.class,
        parentColumns = "id",
        childColumns = "id",
        onDelete = CASCADE))
public class MovieEntityReviews {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @PrimaryKey

    private int id;
    private String authorName;
    private String content;
}
