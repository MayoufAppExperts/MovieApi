package com.example.theappexperts.movieapi.network.service;

import com.example.theappexperts.movieapi.network.model.API_Constants;
import com.example.theappexperts.movieapi.MyApp;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TheAppExperts on 28/09/2017.
 */

public class ConnectionService {

    static Retrofit retrofit;
    static OkHttpClient okHttpClient;

    public static reqInterface getConnectionService() {

        okHttpClient = buildClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(reqInterface.class);
    }

    public static OkHttpClient buildClient() {
//
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor).build();
        // Enable response caching
        builder.addNetworkInterceptor(new Offline_CacheData.ResponseCacheInterceptor());
        builder.addInterceptor(new Offline_CacheData.OfflineResponseCacheInterceptor())
                // Set the cache location and size (5 MB)
                .cache(new okhttp3.Cache(new File(MyApp
                        .getContext().getCacheDir(),
                        "apiResponses"), 5 * 1024 * 1024));
        return new OkHttpClient();


    }
}