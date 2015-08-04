package com.twu.cmd;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Movie;

import java.util.List;

/**
 * Created by dan on 15-8-4.
 */
public class ListMovieCmd implements Cmd {
    @Override
    public void execute() {
        System.out.println("All movies are as follows:");
        List<Movie> movies = Biblioteca.getAllMovies();
        final int[] index = {1};
        movies.stream().forEach((movie) -> {
            System.out.println(index[0] + ". " + movie.getName());
            index[0]++;
        });
    }
}
