package com.example.theappexperts.movieapi.ui.movieDetail;

import com.example.theappexperts.movieapi.DataManager;
import com.example.theappexperts.movieapi.network.model.API_Constants;
import com.example.theappexperts.movieapi.ui.base.BasePresenter;
import com.example.theappexperts.movieapi.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public class iMovieDetailPresenter
    <V extends iMovieDetailMvpView>
    extends BasePresenter<V>
    implements iMovieDetailMvpPresenter<V>{


    public iMovieDetailPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onDetailViewPrepared() {

        getCompositeDisposable().add(getDataManager()
                .useCaseMovieDetails(, API_Constants.API_KEY)

    }
}
