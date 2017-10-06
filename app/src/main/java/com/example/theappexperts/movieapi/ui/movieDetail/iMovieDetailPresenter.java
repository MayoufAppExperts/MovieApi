package com.example.theappexperts.movieapi.ui.movieDetail;

import com.example.theappexperts.movieapi.DataManager;
import com.example.theappexperts.movieapi.network.model.API_Constants;
import com.example.theappexperts.movieapi.network.model.MoviesResponse;
import com.example.theappexperts.movieapi.ui.base.BasePresenter;
import com.example.theappexperts.movieapi.ui.utils.rx.SchedulerProvider;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

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
                .useCaseMovieDetails(1, API_Constants.API_KEY)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<MoviesResponse>() {
                               @Override
                               public void accept(@NonNull MoviesResponse moviesResponse) throws Exception {
                                   getMvpView().onFetchDetailCompleted(moviesResponse);
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
