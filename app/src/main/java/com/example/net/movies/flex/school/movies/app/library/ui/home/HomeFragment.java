package com.example.net.movies.flex.school.movies.app.library.ui.home;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import com.example.net.movies.flex.school.movies.app.library.adapters.PopularAdapter;
import com.example.net.movies.flex.school.movies.app.library.databinding.FragmentHomeBinding;
import com.example.net.movies.flex.school.movies.app.library.models.popular.ResultsItem;
import com.example.net.movies.flex.school.movies.app.library.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private PopularAdapter adapter;
    private List<ResultsItem> movies = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel.getPopularMovies(Constants.API_KEY)
                .observe(getViewLifecycleOwner(), popularResponse -> {
                    try {
                        if (popularResponse != null && popularResponse.getResults() != null) {
                            Log.d("HomeViewModel", "popular view model observer " + popularResponse.getResults().size());
                            adapter.updateList(popularResponse.getResults());
                            adapter.notifyDataSetChanged();
                        } else
                            Log.d("HomeViewModel", "popular view model observer : response is null");
                    } catch (Exception e) {
                        Log.e("HomeViewModel", e.getMessage());
                    }
                });
        updateRecyclerViewUI();
    }

    private void updateRecyclerViewUI() {
        adapter = new PopularAdapter(movies);
        binding.recyclerPopular.setHasFixedSize(true);
        binding.recyclerPopular.setAdapter(adapter);
        binding.recyclerPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.recyclerPopular);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}