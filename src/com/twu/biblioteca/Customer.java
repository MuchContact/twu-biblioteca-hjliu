package com.twu.biblioteca;

/**
 * Created by dan on 15-7-28.
 */
public class Customer {
    private final String name;
    private final String libraryNumber;
    private final String email;
    private final String telephone;
    private final String psw;

    public Customer(String libraryNumber, String psw, String name, String email, String telephone) {
        this.libraryNumber = libraryNumber;
        this.psw = psw;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public boolean checkout(String bookTitle) {
        Book book = Biblioteca.getBook(bookTitle);
        return book.checkout(name);
    }

    public boolean returnBook(String bookTitle) {
        Book book = Biblioteca.getBook(bookTitle);
        return book.return2Biblioteca(name);
    }

    public boolean checkoutMovie(String name) {
        Movie movie = Biblioteca.getMovie(name);
        return movie.checkout(this.name);
    }

    public boolean checkPsw(String password) {
        return psw.equals(password);
    }

    public boolean returnMovie(String name) {
        Movie movie = Biblioteca.getMovie(name);
        return movie.return2Biblioteca(name);
    }
}
