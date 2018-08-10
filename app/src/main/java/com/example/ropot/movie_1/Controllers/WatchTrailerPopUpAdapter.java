package com.example.ropot.movie_1.Controllers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.ropot.movie_1.R;
import java.util.List;


public class WatchTrailerPopUpAdapter extends RecyclerView.Adapter<WatchTrailerPopUpAdapter.MyHolder> {

    Context mContext;
    List<String> mKeyHolder;

    public WatchTrailerPopUpAdapter(Context context, List<String> keyHolder){
        mContext = context;
        mKeyHolder = keyHolder;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.watch_trailer_item, null);
        MyHolder myHolder = new MyHolder(layout);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        int count = position + 1;
        holder.textView.setText("Watch Trailer " + count);
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            String url = "https://www.youtube.com/watch?v=" + mKeyHolder.get(position);
            Uri uri = Uri.parse(url);
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mKeyHolder.size();
    }

    public static  class MyHolder extends RecyclerView.ViewHolder{

        ImageButton imageButton;
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.image_button_trailer);
            textView = itemView.findViewById(R.id.watch_trailer_label);
        }
    }
}
