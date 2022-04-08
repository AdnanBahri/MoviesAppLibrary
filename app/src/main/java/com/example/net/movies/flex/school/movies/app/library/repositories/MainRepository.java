package com.example.net.movies.flex.school.movies.app.library.repositories;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;

import com.example.net.movies.flex.school.movies.app.library.models.popular.PopularResponse;
import com.example.net.movies.flex.school.movies.app.library.network.Api;
import com.example.net.movies.flex.school.movies.app.library.network.RetrofitClient;

import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainRepository {

    private RetrofitClient client = new RetrofitClient();
    private Api api;
    private MutableLiveData<PopularResponse> response;

    public MainRepository() {
        api = client.getInstance().create(Api.class);
        response = new MutableLiveData<>();
    }

    public LiveData<PopularResponse> getPopularMovies(String key) {
        return LiveDataReactiveStreams.fromPublisher(
                api.getPopularMovies(key)
                        .subscribeOn(Schedulers.io())
                        .onErrorReturn(err-> new PopularResponse())

        );
    }
}
