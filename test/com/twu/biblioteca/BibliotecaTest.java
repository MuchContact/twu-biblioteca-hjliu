package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static com.twu.biblioteca.Biblioteca.getAllBooks;
import static org.junit.Assert.*;

public class BibliotecaTest {

    private final String bookTitle = "Agile Game Development with Scrum";

    @Test
    public void should_get_all_books() throws Exception {
        List<Book> allBooks = getAllBooks();
        assertEquals(6, allBooks.size());
    }

    @Test
    public void should_get_all_available_books() throws Exception {
        Customer guest = new Customer("guest");
        assertTrue(guest.checkout(bookTitle));
        assertEquals(5, Biblioteca.getAllAvailableBooks().size());
        assertTrue(guest.returnBook(bookTitle));
    }

    @Test
    public void should_contain_detail_info() throws Exception {
        Book book = Biblioteca.getBook(bookTitle);
        assertEquals("Clinton Keith", book.getAuthor());
        assertEquals(2010, book.getPublishedYear());
    }

    @Test
    public void should_each_book_contain_detail_info() throws Exception {
        List<Book> allAvailableBooks = Biblioteca.getAllAvailableBooks();
        allAvailableBooks.stream().forEach((book)
                -> {
            assertNotNull(book.getAuthor());
            assertNotNull(book.getPublishedYear());
        });
    }
}
