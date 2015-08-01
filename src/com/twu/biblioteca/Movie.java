package com.twu.biblioteca;

/**
 * Created by dan on 15-8-1.
 */
public class Movie {
    private String name;
    private int year;
    private String director;
    private int movie_rating;

    public Movie(String name, String director, int year, int rate) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.movie_rating = rate;
    }
}
