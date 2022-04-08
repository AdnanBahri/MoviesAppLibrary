package com.example.net.movies.flex.school.movies.app.library.ui.home;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.net.movies.flex.school.movies.app.library.models.popular.PopularResponse;
import com.example.net.movies.flex.school.movies.app.library.repositories.MainRepository;

public class HomeViewModel extends ViewModel {

    private MainRepository repo;

    public HomeViewModel() {
        repo = new MainRepository();
    }

    public LiveData<PopularResponse> getPopularMovies(String key) {
        return repo.getPopularMovies(key);
    }

}