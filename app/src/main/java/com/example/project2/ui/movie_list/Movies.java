package com.example.project2.ui.movie_list;

import java.io.Serializable;

public class Movies implements Serializable
{
    //Properties of the movie list
    private final String title;
    private final String description;
    private final String releaseDate;
    private final double rating;
    private final String imageUrl;

    //Represents a movie with title, description, etc.

    public Movies(String title, String description, String releaseDate, double rating, String imageUrl) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
