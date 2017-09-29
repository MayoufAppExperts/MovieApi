package com.example.theappexperts.movieapi;

import com.example.theappexperts.movieapi.network.ApiHelper;
import com.example.theappexperts.movieapi.network.AppApiHelper;
import com.example.theappexperts.movieapi.network.model.MoviesResponse;
import com.example.theappexperts.movieapi.network.model.PlayerInfo;

import io.reactivex.Observable;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;

    public AppDataManager() {
        this.apiHelper = new AppApiHelper();
    }

    @Override
    public Observable<PlayerInfo> useCaseMoviesList(String apiKey) {
        return apiHelper.useCaseMoviesList(apiKey);
    }

    @Override
    public Observable<MoviesResponse> useCaseMovieDetails(int id, String apiKey) {
        return apiHelper.useCaseMovieDetails(id, apiKey);
    }
}
