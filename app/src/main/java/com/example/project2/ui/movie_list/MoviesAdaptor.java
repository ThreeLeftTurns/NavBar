package com.example.project2.ui.movie_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import android.widget.ImageView;






import com.example.project2.R;

import java.util.List;

public class MoviesAdaptor extends RecyclerView.Adapter<MoviesAdaptor.MovieViewHolder> {

    private LayoutInflater inflater;
    private List<Movies> moviesList;
    private OnItemClickListener listener;

    // Constructor
    public MoviesAdaptor(Context context, List<Movies> moviesList, OnItemClickListener listener) {
        this.inflater = LayoutInflater.from(context);
        this.moviesList = moviesList;
        this.listener = listener;
    }

    // Create new views
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.movie_items, parent, false);
        return new MovieViewHolder(itemView);
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movies currentMovie = moviesList.get(position);
        holder.bind(currentMovie);
    }

    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return moviesList == null ? 0 : moviesList.size();
    }

    // Interface for click events
    public interface OnItemClickListener {
        void onItemClick(Movies movie);
    }

    // Provide a reference to the views for each data item
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView descriptionTextView;

        private ImageView movieImageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.movieTitle);
            descriptionTextView = itemView.findViewById(R.id.movieDescription);
            movieImageView = itemView.findViewById(R.id.movieImage);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(moviesList.get(position));
                }
            });
        }

        public void bind(Movies movie) {
            titleTextView.setText(movie.getTitle());
            descriptionTextView.setText(movie.getDescription());
            Glide.with(itemView.getContext())
                    .load(movie.getImageUrl())
                    .into(movieImageView);
        }
    }
}