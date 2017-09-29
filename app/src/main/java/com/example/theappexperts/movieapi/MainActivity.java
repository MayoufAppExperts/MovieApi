package com.example.theappexperts.movieapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.theappexperts.movieapi.network.model.PlayerInfo;
import com.example.theappexperts.movieapi.network.model.Result;
import com.example.theappexperts.movieapi.network.service.OnItemClickListener;
import com.example.theappexperts.movieapi.ui.movieList.MovieListPresenter;
import com.example.theappexperts.movieapi.ui.movieList.iMovieListMvpView;
import com.example.theappexperts.movieapi.ui.utils.rx.AppSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements iMovieListMvpView {

    private MovieListPresenter<iMovieListMvpView> iMovieListMvpViewMovieListPresenter;

    public RecyclerView recyclerView;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseRecyclerView();

        iMovieListMvpViewMovieListPresenter = new MovieListPresenter<>(
                new AppDataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable());

        iMovieListMvpViewMovieListPresenter.onAttach(this);
        iMovieListMvpViewMovieListPresenter.onViewPrepared();

    }

    public void initialiseRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Log.i("RecyclerCheck", "has been initialised");
    }

    @Override
    public void onFetchDataCompleted(PlayerInfo playerInfo) {
        Log.i("MovieList", String.valueOf(playerInfo.getResults()));
        recyclerView.setAdapter(new MovieAdapter(playerInfo.getResults(), R.layout.list_item_movie, getApplicationContext(), new OnItemClickListener() {
            @Override
            public void onItemClick(Result result) {
                Log.i("Check", "onitemclick working");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class)
                        .putExtra("id", result.getId());
                startActivity(intent);
                toast.makeText(getApplicationContext(), "Item Clicked", Toast.LENGTH_LONG).show();
            }
        }));

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }
}
