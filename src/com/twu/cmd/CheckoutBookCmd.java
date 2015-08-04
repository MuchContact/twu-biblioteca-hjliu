package com.twu.cmd;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;

/**
 * Created by dan on 15-8-4.
 */
public class CheckoutBookCmd implements Cmd{
    private int bookIndex;
    private Customer user;

    public CheckoutBookCmd(int bookIndex, Customer user) {
        this.bookIndex = bookIndex;
        this.user = user;
    }

    @Override
    public void execute() {
        Book book = Biblioteca.getBookByIndex(bookIndex);
        if(user.checkout(book.getTitle())) {
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }

    }
}
