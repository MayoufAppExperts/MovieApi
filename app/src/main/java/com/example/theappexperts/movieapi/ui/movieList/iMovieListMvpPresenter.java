package com.example.theappexperts.movieapi.ui.movieList;

import com.example.theappexperts.movieapi.ui.base.MvpPresenter;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public interface iMovieListMvpPresenter<V extends iMovieListMvpView> extends MvpPresenter<V> {

    void  onViewPrepared();
}
