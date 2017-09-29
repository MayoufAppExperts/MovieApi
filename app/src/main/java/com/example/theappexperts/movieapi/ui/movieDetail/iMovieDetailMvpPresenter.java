package com.example.theappexperts.movieapi.ui.movieDetail;

import com.example.theappexperts.movieapi.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public interface iMovieDetailMvpPresenter <V extends iMovieDetailMvpView> extends MvpPresenter <V> {

    void onDetailViewPrepared();
}
