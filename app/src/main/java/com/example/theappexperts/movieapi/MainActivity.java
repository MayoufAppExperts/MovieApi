package com.example.theappexperts.movieapi;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.theappexperts.movieapi.pojo.PlayerInfo;
import com.example.theappexperts.movieapi.pojo.Result;
import com.example.theappexperts.movieapi.services.ConnectionService;
import com.example.theappexperts.movieapi.services.reqInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public reqInterface varReqInter;
    public RecyclerView recyclerView;
    SwipeRefreshLayout mySwipeRefreshLayout;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseRecyclerView();
        connectionStuff();

    }

    public void connectionStuff() {
        varReqInter = ConnectionService.getConnectionService();
        varReqInter.getMoviesList(API_Constants.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::onSuccess, this::onError);
    }

    public void onError(Throwable throwable) {
        Log.i("CakeList", throwable.getMessage());

    }

    public void onSuccess(PlayerInfo playerInfo) {
        Log.i("CakeList", String.valueOf(playerInfo.getResults()));
        recyclerView.setAdapter(new MovieAdapter(playerInfo.getResults(), R.layout.list_item_movie, getApplicationContext()));
    }

    public void initialiseRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
