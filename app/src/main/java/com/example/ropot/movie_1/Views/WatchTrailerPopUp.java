
package com.example.ropot.movie_1.Views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.example.ropot.movie_1.R;
public class WatchTrailerPopUp extends Activity {

    RecyclerView recyclerView;
    String results;
    Bundle bundle;
    //List<MovieDetails.ResultsBean> resultsBeans;
    LinearLayoutManager linearLayoutManager;
    //List<String> movieKeys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_trailer_pop_up);

        recyclerView = findViewById(R.id.recycler_watch_trailer);
        linearLayoutManager = new LinearLayoutManager(WatchTrailerPopUp.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        results = new String();
        bundle = new Bundle();
        int movieId;



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8), (int) (height*.8));


        movieId = getIntent().getIntExtra("m", 0);

        Toast.makeText(WatchTrailerPopUp.this, String.valueOf(movieId), Toast.LENGTH_LONG).show();

        //results = new ArrayList<>();
        /*Intent intent = getIntent();
        if(intent.hasExtra("mk")){
            Toast.makeText(WatchTrailerPopUp.this, "Yessssssss", Toast.LENGTH_LONG).show();
            String test = intent.getStringExtra("mk");
            Toast.makeText(WatchTrailerPopUp.this, test, Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(WatchTrailerPopUp.this, "Nooooooooo", Toast.LENGTH_LONG).show();
        }*/
        /*bundle = getIntent().getBundleExtra("mk");
        String test = bundle.get("mk").toString();

        results = bundle.getString("mm");

        Toast.makeText(WatchTrailerPopUp.this, "Hi *** " + test, Toast.LENGTH_LONG).show();
*/



      //  movieKeys = new ArrayList<>();

        //resultsBeans = results.getResults();
        /*for(int i = 0; i<resultsBeans.size(); i++) {

            String movieKey = resultsBeans.get(i).getKey();
            movieKeys.add(movieKey);
            Toast.makeText(WatchTrailerPopUp.this, resultsBeans.get(0).getKey(), Toast.LENGTH_LONG).show();
        }*/

        //WatchTrailerPopUpAdapter watchTrailerPopUpAdapter = new WatchTrailerPopUpAdapter(WatchTrailerPopUp.this, movieKeys);
        //recyclerView.setAdapter(watchTrailerPopUpAdapter);
    }
}
