package com.twu.cmd;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;

import java.util.List;

/**
 * Created by dan on 15-8-4.
 */
public class ListBooksCmd implements Cmd{

    @Override
    public void execute() {
        System.out.println("All books are as follows:");
        List<Book> bookList = Biblioteca.getAllBooks();
        final int[] index = {1};
        bookList.stream().forEach((book) -> {
            System.out.println(index[0] + ". " + book.getTitle());
            index[0]++;
        });
    }
}
