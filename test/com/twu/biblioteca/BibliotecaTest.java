package com.twu.biblioteca;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.twu.biblioteca.Biblioteca.getAllBooks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    private final String bookTitle = "Agile Game Development with Scrum";

    @BeforeClass
    public static void setUp() throws Exception {
        Biblioteca.fillBibliotecaWithBooks();
    }

    @Test
    public void should_list_all_books() throws Exception {
        List<Book> allBooks = getAllBooks();
        assertEquals(6, allBooks.size());
    }

    @Test
    public void should_list_all_available_books() throws Exception {
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
                ->{ assertNotNull(book.getAuthor());
                    assertNotNull(book.getPublishedYear());
                });
    }
}
