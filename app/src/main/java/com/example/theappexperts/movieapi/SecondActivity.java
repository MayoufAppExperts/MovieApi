package com.example.theappexperts.movieapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.theappexperts.movieapi.network.model.MoviesResponse;
import com.example.theappexperts.movieapi.network.model.API_Constants;
import com.example.theappexperts.movieapi.network.service.ConnectionService;
import com.example.theappexperts.movieapi.network.service.reqInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SecondActivity extends AppCompatActivity {

    public reqInterface varReqInter;
    TextView textView;
    int itemID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView)findViewById(R.id.textView);
        itemID = getIntent().getIntExtra("id", 0);

        connectionStuff();


    }

    public void connectionStuff() {
        varReqInter = ConnectionService.getConnectionService();
        varReqInter.getMovieDetails(itemID, API_Constants.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(MoviesResponse moviesResponse) {
        textView.setText(moviesResponse.getTitle());

    }

    public void onError(Throwable throwable) {
        Log.i("CakeList", throwable.getMessage());

    }
}