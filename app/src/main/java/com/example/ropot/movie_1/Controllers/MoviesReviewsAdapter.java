package com.example.ropot.movie_1.Controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ropot.movie_1.Models.MovieReviews;
import com.example.ropot.movie_1.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesReviewsAdapter extends RecyclerView.Adapter<MoviesReviewsAdapter.MyHolder> {

    private Context mContext;
    //private ArrayList<MovieReviews> mReviews;
    //List<MovieReviews.ResultsBean> resultsBeans;
    private List<String> mAuthorName;
    private List<String> mContentText;

    public MoviesReviewsAdapter(Context context, List<String> authorName, List<String> contentText) {

        mContext = context;
        mAuthorName = authorName;
        mContentText = contentText;


    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviews_item, null);
        MyHolder myHolder = new MyHolder(layout);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        //resultsBeans = mReviews.get(position).getResults();
        holder.author.setText(mAuthorName.get(position));
        holder.textReviews.setText(mContentText.get(position));

    }


    @Override
    public int getItemCount() {
        return mAuthorName.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder{

        TextView author;
        TextView textReviews;

        public MyHolder(View itemView) {
            super(itemView);

            author = itemView.findViewById(R.id.author);
            textReviews = itemView.findViewById(R.id.review_content);

        }
    }
}
