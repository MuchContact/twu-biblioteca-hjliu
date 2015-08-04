package com.twu.cmd;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;

/**
 * Created by dan on 15-8-4.
 */
public class ShowBookDetailCmd implements Cmd{

    private int bookIndex;

    public ShowBookDetailCmd(int bookIndex) {
        this.bookIndex = bookIndex;
    }

    @Override
    public void execute() {
        Book book = Biblioteca.getBookByIndex(bookIndex);
        System.out.println(book);

    }
}
