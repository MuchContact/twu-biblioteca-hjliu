package com.twu.biblioteca;

/**
 * Created by dan on 15-8-1.
 */
public class Movie {
    private String name;
    private int year;
    private String director;
    private int movie_rating;
    private boolean checkedOut = false;
    private String occupant=null;

    public Movie(String name, String director, int year, int rate) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.movie_rating = rate;
    }

    public String getName() {
        return name;
    }

    public boolean checkout(String username) {
        if(checkedOut){
            return false;
        }
        checkedOut = true;
        this.occupant = username;
        return true;
    }

    public boolean return2Biblioteca(String username) {
        if(this.occupant!=null && this.occupant.equals(username)){
            checkedOut = false;
            this.occupant = null;
            return true;
        }
        return false;
    }
}
