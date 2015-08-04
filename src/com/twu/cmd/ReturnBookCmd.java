package com.twu.cmd;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Customer;

/**
 * Created by dan on 15-8-4.
 */
public class ReturnBookCmd implements Cmd{
    private int bookIndex;
    private Customer user;

    public ReturnBookCmd(Customer user, int bookIndex) {
        this.user = user;
        this.bookIndex = bookIndex;
    }

    @Override
    public void execute() {
        Book book = Biblioteca.getBookByIndex(bookIndex);
        if(user.returnBook(book.getTitle())) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }

    }
}
