package com.example.theappexperts.movieapi.ui.movieList;

import android.util.Log;

import com.example.theappexperts.movieapi.DataManager;
import com.example.theappexperts.movieapi.network.model.API_Constants;
import com.example.theappexperts.movieapi.network.model.PlayerInfo;
import com.example.theappexperts.movieapi.network.model.Result;
import com.example.theappexperts.movieapi.ui.base.BasePresenter;
import com.example.theappexperts.movieapi.ui.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by TheAppExperts on 29/09/2017.
 */

public class MovieListPresenter
        <V extends iMovieListMvpView>
        extends BasePresenter<V>
        implements iMovieListMvpPresenter<V> {

    public MovieListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    public void getHightRated(PlayerInfo playerInfo) {
        Observable.fromArray(playerInfo.getResults())
                .filter(results -> true)
                .subscribe(getObserver());

    }

    private Observer<? super List<Result>> getObserver() {
        return new Observer<List<Result>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<Result> results) {

                for (int i = 0; i < results.size(); i++) {
                    if (results.get(i).getVoteAverage() > 8.4) {
                        Log.i("onNext", "\n" + results.get(i).getVoteAverage().toString());
                    }
                }
                getMvpView().onFilterView(results);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
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
                                   getHightRated(playerInfo);
                                   //getMvpView().onFetchDataCompleted(playerInfo);
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
