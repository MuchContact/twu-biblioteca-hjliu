package com.twu.biblioteca;


import org.junit.Test;

import java.util.List;

import static com.twu.biblioteca.Biblioteca.getAllBooks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    @Test
    public void should_list_all_books() throws Exception {
        Biblioteca.fillBibliotecaWithBooks();
        List<Book> allBooks = getAllBooks();
        assertEquals(6, allBooks.size());
    }

    @Test
    public void should_list_all_available_books() throws Exception {
        Biblioteca.fillBibliotecaWithBooks();
        Customer guest = new Customer("guest");
        assertTrue(guest.checkout("Agile Game Development with Scrum"));
        assertEquals(5, Biblioteca.getAllAvailableBooks().size());
        assertTrue(guest.returnBook("Agile Game Development with Scrum"));
    }
}
