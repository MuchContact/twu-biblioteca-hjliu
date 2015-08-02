package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {


    private static final String QUIT = "Quit";
    private static final String RETURN_BOOK = "return --book";
    private static final String CHECKOUT_BOOK = "checkout --book";
    private static final String SHOW_DETAIL_FOR_BOOK = "show detail for book";
    private static final String LIST_BOOK = "List Books";
    private static final String CHECKOUT_MOVIE = "checkout --movie";
    private static final String RETURN_MOVIE = "return --movie";

    public static void main(String[] args) {
        printWelcome();
        printAllBooksInConsole();
        Scanner in = new Scanner(System.in);
        printOperationInstructions();

        Customer guest = generateCustomer();
        boolean authorized = false;

        while(true){
            if(!authorized){
                authorized = login(in);
                continue;
            }

            String cmd = in.nextLine();
            if(isValidListBooksCmd(cmd)){
                printAllBooksInConsole();
                continue;
            }
            if(isValidShowBookDetailCmd(cmd)){
                int bookIndex = Integer.valueOf(cmd.trim().substring(SHOW_DETAIL_FOR_BOOK.length()).trim());
                Book book = Biblioteca.getBookByIndex(bookIndex);
                System.out.println(book);
                continue;
            }
            if(isValidCheckoutBookCmd(cmd)){
                int bookIndex = Integer.valueOf(cmd.trim().substring(CHECKOUT_BOOK.length()).trim());
                Book book = Biblioteca.getBookByIndex(bookIndex);
                if(guest.checkout(book.getTitle())) {
                    System.out.println("Thank you! Enjoy the book");
                } else {
                    System.out.println("That book is not available.");
                }
                continue;
            }
            if(isValidReturnBookCmd(cmd)){
                int bookIndex = Integer.valueOf(cmd.trim().substring(RETURN_BOOK.length()).trim());
                Book book = Biblioteca.getBookByIndex(bookIndex);
                if(guest.returnBook(book.getTitle())) {
                    System.out.println("Thank you for returning the book.");
                } else {
                    System.out.println("That is not a valid book to return.");
                }
                continue;
            }
            if(isValidCheckoutMovieCmd(cmd)){
                int movieIndex = Integer.valueOf(cmd.trim().substring(CHECKOUT_MOVIE.length()).trim());
                Movie movie= Biblioteca.getMovieByIndex(movieIndex);
                if(guest.checkout(movie.getName())) {
                    System.out.println("Thank you! Enjoy the movie");
                } else {
                    System.out.println("That movie is not available.");
                }
                continue;
            }
            if(isValidReturnMovieCmd(cmd)){
                int movieIndex = Integer.valueOf(cmd.trim().substring(RETURN_MOVIE.length()).trim());
                Movie movie = Biblioteca.getMovieByIndex(movieIndex);
                if(guest.returnBook(movie.getName())) {
                    System.out.println("Thank you for returning the movie.");
                } else {
                    System.out.println("That is not a valid movie to return.");
                }
                continue;
            }
            if(isValidListMoviewCmd(cmd)){
                printAllMoviesInConsole();
                continue;
            }
            if(isValidQuitAppCmd(cmd)){
                break;
            }

            System.out.println("Select a valid option!");
        }

    }

    private static boolean isValidReturnMovieCmd(String cmd) {
        return cmd.trim().contentEquals(RETURN_MOVIE);
    }

    private static boolean isValidCheckoutMovieCmd(String cmd) {
        return cmd.trim().contentEquals(CHECKOUT_MOVIE);
    }

    private static void printAllMoviesInConsole() {
        System.out.println("All movies are as follows:");
        List<Movie> movies = Biblioteca.getAllMovies();
        final int[] index = {1};
        movies.stream().forEach((movie) -> {
            System.out.println(index[0] + ". " + movie.getName());
            index[0]++;
        });
    }

    private static boolean isValidListMoviewCmd(String cmd) {
        return cmd.trim().equalsIgnoreCase("List Movies");
    }

    private static void printWelcome() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("");
    }

    private static void printOperationInstructions() {
        System.out.println("Operation Options: ");
        System.out.println("    1: List Books");
        System.out.println("(Notes: )");
    }

    private static void printAllBooksInConsole() {
        System.out.println("All books are as follows:");
        List<Book> bookList = Biblioteca.getAllBooks();
        final int[] index = {1};
        bookList.stream().forEach((book) -> {
            System.out.println(index[0] + ". " + book.getTitle());
            index[0]++;
        });
    }

    private static boolean login(Scanner in) {
        System.out.print("Please enter library number:");
        String libraryNumber = in.nextLine();
        System.out.print("Please enter password:");
        String password = in.nextLine();
        try {
            Biblioteca.login(libraryNumber, password);
            return true;
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    private static Customer generateCustomer() {
        String libraryNumber = "100-1234";
        String password = "default";
        try {
            return Biblioteca.login(libraryNumber, password);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean isValidQuitAppCmd(String cmd) {
        return cmd.trim().equalsIgnoreCase(QUIT);
    }

    private static boolean isValidReturnBookCmd(String cmd) {
        return cmd.trim().contains(RETURN_BOOK);
    }

    private static boolean isValidCheckoutBookCmd(String cmd) {
        return cmd.trim().contains(CHECKOUT_BOOK);
    }

    private static boolean isValidShowBookDetailCmd(String cmd) {
        return cmd.trim().contains(SHOW_DETAIL_FOR_BOOK);
    }

    private static boolean isValidListBooksCmd(String cmd) {
        return cmd.trim().equalsIgnoreCase(LIST_BOOK);
    }

}
