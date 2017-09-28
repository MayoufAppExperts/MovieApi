package com.example.theappexperts.movieapi.services;


import com.example.theappexperts.movieapi.pojo.PlayerInfo;
import com.example.theappexperts.movieapi.pojo.Result;

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
    //Observable<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
