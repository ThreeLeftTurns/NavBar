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

//Adapter for handling RecyclerView of movies

public class MoviesAdaptor extends RecyclerView.Adapter<MoviesAdaptor.MovieViewHolder> {

    //For inflating layout in onCreateViewHolder
    private final LayoutInflater inflater;
    //List to keep movies to display
    private final List<Movies> moviesList;
    // Listener for item clicks
    private final OnItemClickListener listener;

    //Adapter constructor
    public MoviesAdaptor(Context context, List<Movies> moviesList, OnItemClickListener listener) {
        this.inflater = LayoutInflater.from(context);
        this.moviesList = moviesList;
        this.listener = listener;
    }

   //New ViewHolder for RecyclerView
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.movie_items, parent, false);
        return new MovieViewHolder(itemView);
    }

    //Bind movie data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movies currentMovie = moviesList.get(position);
        holder.bind(currentMovie);
    }

    //Return the size of your dataset
    @Override
    public int getItemCount() {
        return moviesList == null ? 0 : moviesList.size();
    }

    //Get total number of movies
    public interface OnItemClickListener {
        void onItemClick(Movies movie);
    }

    //Constructor to assign view references
    public class MovieViewHolder extends RecyclerView.ViewHolder
    {
        //TextViews and ImageView for the movie item
        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final ImageView movieImageView;

        //Constructor to assign view references
        public MovieViewHolder(@NonNull View itemView)
        {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.movieTitle);
            descriptionTextView = itemView.findViewById(R.id.movieDescription);
            movieImageView = itemView.findViewById(R.id.movieImage);
            //Set click listener for the whole item view
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                //Notify click listener of the current item click
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(moviesList.get(position));
                }
            });
        }
        //Bind movie data to the item views
        public void bind(Movies movie) {
            titleTextView.setText(movie.getTitle());
            descriptionTextView.setText(movie.getDescription());
            //Use Glide to load the movie image
            Glide.with(itemView.getContext())
                    .load(movie.getImageUrl())
                    .into(movieImageView);
        }
    }
}