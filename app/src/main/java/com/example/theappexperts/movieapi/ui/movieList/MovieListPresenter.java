package com.example.theappexperts.movieapi.ui.movieList;

import com.example.theappexperts.movieapi.DataManager;
import com.example.theappexperts.movieapi.network.model.API_Constants;
import com.example.theappexperts.movieapi.network.model.PlayerInfo;
import com.example.theappexperts.movieapi.ui.base.BasePresenter;
import com.example.theappexperts.movieapi.ui.utils.rx.SchedulerProvider;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public class MovieListPresenter
        <V extends iMovieListMvpView>
        extends BasePresenter<V>
        implements iMovieListMvpPresenter<V>{

    public MovieListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getCompositeDisposable().add(getDataManager()
                .useCaseMoviesList(API_Constants.API_KEY)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<PlayerInfo>() {
                               @Override
                               public void accept(@NonNull PlayerInfo playerInfo) throws Exception {
                                   getMvpView().onFetchDataCompleted(playerInfo);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(@NonNull Throwable throwable) throws Exception {
                                getMvpView().onError(throwable.getMessage());
                            }
                        }));

    }
}
