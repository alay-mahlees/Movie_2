package com.example.ropot.movie_1.Controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ropot.movie_1.R;

import java.util.ArrayList;

public class FavoritePosterAdapter extends RecyclerView.Adapter<FavoritePosterAdapter.MyHolder> {

    ArrayList<byte[]> imageByte;
    Context mContext;

    public FavoritePosterAdapter(Context context, ArrayList<byte[]> imageViews) {

        this.mContext = context;
        this.imageByte = imageViews;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.poster_item, null);
       MyHolder myHolder = new MyHolder(layout);

        return myHolder;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        //byte data = imageByte.get(position).byteValue();
       /* byte[] bytes = new byte[imageByte.size()];
        for(int i=0; i<imageByte.size(); i++){
            bytes[i] = imageByte.get(i).byteValue();
        }*/


        byte[] image = imageByte.get(position);

        //holder.posterHolder.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
        holder.posterHolder.setImageBitmap(BitmapFactory.decodeByteArray(image , 0, image.length));

    }

    @Override
    public int getItemCount() {
        //mImageViews = new ArrayList<>();
        return imageByte.size();
    }


    public static class MyHolder extends RecyclerView.ViewHolder {

        ImageView posterHolder;

        public MyHolder(View itemView) {
            super(itemView);
            posterHolder = itemView.findViewById(R.id.imageView);
        }

    }



}
