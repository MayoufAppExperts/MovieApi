package com.example.theappexperts.movieapi.ui.movieDetail;

import com.example.theappexperts.movieapi.network.model.MoviesResponse;
import com.example.theappexperts.movieapi.network.model.PlayerInfo;
import com.example.theappexperts.movieapi.ui.base.MvpView;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public interface iMovieDetailMvpView extends MvpView {

    void onFetchDetailCompleted(MoviesResponse moviesResponse);
}
