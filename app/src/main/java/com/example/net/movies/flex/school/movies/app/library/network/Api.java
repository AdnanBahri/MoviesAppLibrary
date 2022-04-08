package com.example.net.movies.flex.school.movies.app.library.network;

import com.example.net.movies.flex.school.movies.app.library.models.popular.PopularResponse;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("popular")
    Flowable<PopularResponse> getPopularMovies(
            @Query("api_key") String api_key
    );
}
