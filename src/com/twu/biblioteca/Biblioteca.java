package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dan on 15-7-28.
 */
public class Biblioteca {

    private static final List<Book> bookCollection = new ArrayList<Book>();

    public static List<Book> getAllBooks() {
        return bookCollection;
    }

    public static void fillBibliotecaWithBooks() {
        bookCollection.add(new Book("Agile Game Development with Scrum", "Clinton Keith", 2010));
        bookCollection.add(new Book("Agile Project Management with Scrum", "Ken Schwaber", 2004));
        bookCollection.add(new Book("Pro Agile .NET Development with SCRUM", "Scott Millett, Jerrel Blankenship, Matthew Bussa", 2011));
        bookCollection.add(new Book("Scrum and XP from the Trenches: How We Do Scrum", "Henrik Kniberg", 2007));
        bookCollection.add(new Book("A Practical Guide to Distributed Scrum", "Elizabeth Woodward, Steffan Surdek, Matthew Ganis ", 2010));
        bookCollection.add(new Book("Succeeding with Agile: Software Development Using Scrum", "Mike Cohn ", 2010));
    }

    public static List<Book> getAllAvailableBooks() {
        final List<Book> newList = new ArrayList<Book>();
        bookCollection.stream().filter(book->book.isAvailable()).forEach((book)->{newList.add(book);});
        return newList;
    }

    public static Book getBook(String bookTitle) {
        return bookCollection.stream().filter(book->book.getTitle().equals(bookTitle)).findFirst().get();
    }
}
