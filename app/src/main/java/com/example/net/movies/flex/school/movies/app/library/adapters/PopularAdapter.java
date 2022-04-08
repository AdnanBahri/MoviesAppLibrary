package com.example.net.movies.flex.school.movies.app.library.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.net.movies.flex.school.movies.app.library.databinding.MovieItemLayoutBinding;
import com.example.net.movies.flex.school.movies.app.library.models.popular.ResultsItem;
import com.example.net.movies.flex.school.movies.app.library.utils.Constants;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private List<ResultsItem> movies;

    public PopularAdapter(List<ResultsItem> list) {
        movies = list;
    }

    public void updateList(List<ResultsItem> newList) {
        movies.clear();
        movies.addAll(newList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemLayoutBinding binding = MovieItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setupUI(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MovieItemLayoutBinding binding;

        public ViewHolder(@NonNull MovieItemLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void setupUI(ResultsItem item) {
            binding.movieTitle.setText(item.getTitle());
            Glide
                    .with(binding.getRoot())
                    .load(Constants.BASE_URL_IMAGE + item.getPosterPath())
                    .into(binding.moviePoster);
            for (int i = 0; i < item.getGenreIds().size(); i++) {
                binding.movieGenres.setText(item.getGenreIds().get(i) + " ");
            }
            binding.movieCard.setOnClickListener(v -> Toast.makeText(binding.getRoot().getContext(), "" + item.getTitle(), Toast.LENGTH_SHORT).show());
        }
    }
}
