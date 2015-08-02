package com.twu.biblioteca;

import java.util.*;

/**
 * Created by dan on 15-7-28.
 */
public class Biblioteca {

    private static final List<Book> bookCollection = new ArrayList<Book>();
    private static List<Movie> movieCollection = new ArrayList<Movie>();
    private static Map<String, Customer> customers = new HashMap<String, Customer>();

    static {
        bookCollection.add(new Book("Agile Game Development with Scrum", "Clinton Keith", 2010));
        bookCollection.add(new Book("Agile Project Management with Scrum", "Ken Schwaber", 2004));
        bookCollection.add(new Book("Pro Agile .NET Development with SCRUM", "Scott Millett, Jerrel Blankenship, Matthew Bussa", 2011));
        bookCollection.add(new Book("Scrum and XP from the Trenches: How We Do Scrum", "Henrik Kniberg", 2007));
        bookCollection.add(new Book("A Practical Guide to Distributed Scrum", "Elizabeth Woodward, Steffan Surdek, Matthew Ganis ", 2010));
        bookCollection.add(new Book("Succeeding with Agile: Software Development Using Scrum", "Mike Cohn ", 2010));

        movieCollection.add(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9));
        movieCollection.add(new Movie("The Godfather", "Francis Ford Coppola", 1972, 9));
        movieCollection.add(new Movie("The Dark Knight", "Christopher Nolan", 2008, 8));
        movieCollection.add(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8));

        customers.put("100-1234", new Customer("100-1234", "default", "guest", "liuhengjiangis@foxmail.com", "13277940890"));
    }

    public static List<Book> getAllBooks() {
        return Collections.unmodifiableList(bookCollection);
    }

    public static List<Book> getAllAvailableBooks() {
        final List<Book> newList = new ArrayList<Book>();
        bookCollection.stream().filter(book->book.isAvailable()).forEach((book)->{newList.add(book);});
        return newList;
    }

    public static Book getBook(String bookTitle) {
        return bookCollection.stream().filter(book->book.getTitle().equals(bookTitle)).findFirst().get();
    }

    public static Book getBookByIndex(int index) {
        return bookCollection.get(index-1);
    }

    public static List<Movie> getAllMovies() {
        return Collections.unmodifiableList(movieCollection);
    }

    public static Movie getMovie(String name) {
        return movieCollection.stream().filter(movie->movie.getName().equals(name)).findFirst().get();
    }

    public static Customer login(String libraryNumber, String password) throws IllegalAccessException {
        if(isCustomerExisted(libraryNumber)){
            if(isLibraryNumberAndPasswordMatched(libraryNumber, password)){
                return getUser(libraryNumber);
            }
            throw new IllegalAccessException("Password Error!");
        }
        throw new IllegalAccessException("The library number is invalid!");
    }

    private static Customer getUser(String libraryNumber) {
        return customers.get(libraryNumber);
    }

    private static boolean isCustomerExisted(String libraryNumber) {
        return customers.get(libraryNumber)==null ? false : true;
    }

    private static boolean isLibraryNumberAndPasswordMatched(String libraryNumber, String password) {
        return customers.get(libraryNumber).checkPsw(password);
    }

    public static Movie getMovieByIndex(int movieIndex) {
        return movieCollection.get(movieIndex-1);
    }
}
