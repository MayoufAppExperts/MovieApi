package com.example.theappexperts.movieapi.ui.movieList;

import com.example.theappexperts.movieapi.network.model.MoviesResponse;
import com.example.theappexperts.movieapi.network.model.PlayerInfo;
import com.example.theappexperts.movieapi.ui.base.MvpView;

import java.util.List;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public interface iMovieListMvpView extends MvpView {

    void onFetchDataCompleted(PlayerInfo playerInfo);
}
