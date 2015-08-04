package com.twu.cmd;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Movie;

/**
 * Created by dan on 15-8-4.
 */
public class ReturnMovieCmd implements Cmd {
    private int movieIndex;
    private Customer user;

    public ReturnMovieCmd(int movieIndex, Customer user) {
        this.movieIndex = movieIndex;
        this.user = user;
    }

    @Override
    public void execute() {
        Movie movie = Biblioteca.getMovieByIndex(movieIndex);
        if(user.returnMovie(movie.getName())) {
            System.out.println("Thank you for returning the movie.");
        } else {
            System.out.println("That is not a valid movie to return.");
        }
    }
}
