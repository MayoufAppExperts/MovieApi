package com.example.theappexperts.movieapi.network.service;


import com.example.theappexperts.movieapi.network.model.MoviesResponse;
import com.example.theappexperts.movieapi.network.model.PlayerInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by TheAppExperts on 28/09/2017.
 */

public interface reqInterface {

    @GET("movie/top_rated")
    Observable<PlayerInfo> getMoviesList(@Query("api_key")String apiKey);
    //http://api.themoviedb.org/3/movie/550?api_key=7e8f60e325cd06e164799af1e317d7a7
    @GET("movie/{id}")
    Observable<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}