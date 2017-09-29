package com.example.theappexperts.movieapi.network;

import com.example.theappexperts.movieapi.network.model.MoviesResponse;
import com.example.theappexperts.movieapi.network.model.PlayerInfo;
import com.example.theappexperts.movieapi.network.service.ConnectionService;
import com.example.theappexperts.movieapi.network.service.reqInterface;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public class AppApiHelper implements  ApiHelper{

    private reqInterface myReqInterface;

    public AppApiHelper() { this.myReqInterface = ConnectionService.getConnectionService();
    }

    @Override
    public Observable<PlayerInfo> useCaseMoviesList(String apiKey) {
        return myReqInterface.getMoviesList(apiKey);
    }

    @Override
    public Observable<MoviesResponse> useCaseMovieDetails(int id, String apiKey) {
        return myReqInterface.getMovieDetails(id, apiKey);
    }
}
