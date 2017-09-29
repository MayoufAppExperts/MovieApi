package com.example.theappexperts.movieapi.network;

import com.example.theappexperts.movieapi.network.model.MoviesResponse;
import com.example.theappexperts.movieapi.network.model.PlayerInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public interface ApiHelper {

    Observable<PlayerInfo> useCaseMoviesList(String apiKey);

    //http://api.themoviedb.org/3/movie/550?api_key=7e8f60e325cd06e164799af1e317d7a7
    Observable<MoviesResponse> useCaseMovieDetails(int id, String apiKey);
}
