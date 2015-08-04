package com.twu.cmd;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Movie;

/**
 * Created by dan on 15-8-4.
 */
public class CheckoutMovieCmd implements Cmd {
    private int movieIndex;
    private Customer user;

    public CheckoutMovieCmd(int movieIndex, Customer user) {
        this.movieIndex = movieIndex;
        this.user = user;
    }

    @Override
    public void execute() {
        Movie movie= Biblioteca.getMovieByIndex(movieIndex);
        if(user.checkout(movie.getName())) {
            System.out.println("Thank you! Enjoy the movie");
        } else {
            System.out.println("That movie is not available.");
        }

    }
}
