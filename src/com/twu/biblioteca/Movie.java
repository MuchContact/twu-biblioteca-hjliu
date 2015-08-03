package com.twu.biblioteca;

/**
 * Created by dan on 15-8-1.
 */
public class Movie extends Item{
    private String name;
    private int year;
    private String director;
    private int movie_rating = -1;

    public Movie(String name, String director, int year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public Movie(String name, String director, int year, int rate) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.movie_rating = rate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", movie_rating=" + ((movie_rating>0)?movie_rating:"unrated") +
                '}';
    }
}
