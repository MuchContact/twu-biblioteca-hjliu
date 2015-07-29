package com.twu.biblioteca;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.twu.biblioteca.Biblioteca.getAllBooks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {
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
        String title = "Agile Game Development with Scrum";
        assertTrue(guest.checkout(title));
        assertEquals(5, Biblioteca.getAllAvailableBooks().size());
        assertTrue(guest.returnBook(title));
    }

    @Test
    public void should_contain_detail_info() throws Exception {
        Book book = Biblioteca.getBook("Agile Game Development with Scrum");
        assertEquals("Clinton Keith", book.getAuthor());
        assertEquals(2010, book.getPublishedYear());
    }
}
