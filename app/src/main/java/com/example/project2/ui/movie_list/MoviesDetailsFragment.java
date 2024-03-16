package com.example.project2.ui.movie_list;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.project2.R;

public class MoviesDetailsFragment extends Fragment {



    private static final String ARG_MOVIE = "movie";
    private Movies movie;

    public MoviesDetailsFragment() {
        // Required empty public constructor
    }

    public static MoviesDetailsFragment newInstance(Movies movie) {
        MoviesDetailsFragment fragment = new MoviesDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MOVIE, movie); // Ensure Movies class implements Serializable
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movie = (Movies) getArguments().getSerializable("movie");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.moviedetailsactivity, container, false);

        // Initialize the views
        ImageView movieImage = view.findViewById(R.id.movieImage);
        TextView movieDescription = view.findViewById(R.id.movieDescription);
        TextView movieTitle = view.findViewById(R.id.movieTitle);
        TextView releaseDate = view.findViewById(R.id.release_date);
        TextView rating = view.findViewById(R.id.rating);

        // Set the content
        Glide.with(this).load(movie.getImageUrl()).into(movieImage);
        movieDescription.setText(movie.getDescription());
        movieTitle.setText(movie.getTitle());
        releaseDate.setText(movie.getReleaseDate());
        rating.setText(String.valueOf(movie.getRating()));

        return view;
    }

}
