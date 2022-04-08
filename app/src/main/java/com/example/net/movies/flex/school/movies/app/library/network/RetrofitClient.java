package com.example.net.movies.flex.school.movies.app.library.network;


import com.example.net.movies.flex.school.movies.app.library.utils.Constants;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private Retrofit instance;

    public Retrofit getInstance() {
        if (instance == null)
            instance = new Retrofit
                    .Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build();
        return instance;
    }
}
