package com.twu.biblioteca;

/**
 * Created by dan on 15-7-28.
 */
public class Customer {
    private final String username;

    public Customer(String username) {
        this.username = username;
    }

    public boolean checkout(String bookTitle) {
        Book book = Biblioteca.getBook(bookTitle);
        return book.checkout(username);
    }

    public boolean returnBook(String bookTitle) {
        Book book = Biblioteca.getBook(bookTitle);
        return book.return2Biblioteca(username);
    }

    public boolean checkoutMovie(String name) {
        Movie movie = Biblioteca.getMovie(name);
        return movie.checkout(username);
    }
}
