package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.twu.biblioteca.Biblioteca.getAllBooks;
import static org.junit.Assert.*;

public class BibliotecaTest {

    private final String bookTitle = "Agile Game Development with Scrum";
    private Customer guest;

    @Before
    public void setUp() throws Exception {
        String libraryNumber = "100-1234";
        String password = "default";
        guest = Biblioteca.login(libraryNumber, password);

    }

    @Test
    public void should_get_all_books() throws Exception {
        List<Book> allBooks = getAllBooks();
        assertEquals(6, allBooks.size());
    }

    @Test
    public void should_get_all_available_books() throws Exception {
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

    @Test
    public void should_get_all_movies() throws Exception {
        List<Movie> allMovies = Biblioteca.getAllMovies();
        assertEquals(4, allMovies.size());
    }

    @Test
    public void should_checkout_movie() throws Exception {
        String name = Biblioteca.getAllMovies().get(0).getName();
        assertTrue(guest.checkoutMovie(name));
    }

    @Test
    public void should_login_with_library_number_and_psw() throws Exception {
        String libraryNumber = "100-1234";
        String password = "default";
        assertNotNull(Biblioteca.login(libraryNumber, password));

    }
}
