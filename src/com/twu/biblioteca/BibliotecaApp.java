package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        printWelcome();
        printAllBooksInConsole();
        Scanner in = new Scanner(System.in);
        printOperationInstructions();

        Customer guest = new Customer("guest");

        while(true){
            String cmd = in.nextLine();
            if(isValidListBooksCmd(cmd)){
                printAllBooksInConsole();
                continue;
            }
            if(isValidShowBookDetailCmd(cmd)){
                int bookIndex = Integer.valueOf(cmd.trim().substring(15).trim());
                Book book = Biblioteca.getBookByIndex(bookIndex);
                System.out.println(book);
                continue;
            }
            if(isValidCheckoutCmd(cmd)){
                int bookIndex = Integer.valueOf(cmd.trim().substring(8).trim());
                Book book = Biblioteca.getBookByIndex(bookIndex);
                if(guest.checkout(book.getTitle())) {
                    System.out.println("Thank you! Enjoy the book");
                } else {
                    System.out.println("That book is not available.");
                }
                continue;
            }
            if(isValidReturnBookCmd(cmd)){
                int bookIndex = Integer.valueOf(cmd.trim().substring(6).trim());
                Book book = Biblioteca.getBookByIndex(bookIndex);
                if(guest.returnBook(book.getTitle())) {
                    System.out.println("Thank you for returning the book.");
                } else {
                    System.out.println("That is not a valid book to return.");
                }
                continue;
            }
            if(isValidQuitAppCmd(cmd)){
                break;
            }

            System.out.println("Select a valid option!");
        }

    }

    private static boolean isValidQuitAppCmd(String cmd) {
        return cmd.trim().equalsIgnoreCase("Quit");
    }

    private static boolean isValidReturnBookCmd(String cmd) {
        return cmd.trim().contains("return");
    }

    private static boolean isValidCheckoutCmd(String cmd) {
        return cmd.trim().contains("checkout");
    }

    private static boolean isValidShowBookDetailCmd(String cmd) {
        return cmd.trim().contains("show detail for");
    }

    private static boolean isValidListBooksCmd(String cmd) {
        return cmd.trim().equalsIgnoreCase("List Books");
    }

    private static void printOperationInstructions() {
        System.out.println("Operation Options: ");
        System.out.println("    1: List Books");
        System.out.println("(Notes: )");
    }

    private static void printWelcome() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("");
    }

    private static void printAllBooksInConsole() {
        System.out.println("All books are as follows:");
        List<Book> bookList = Biblioteca.getAllBooks();
        final int[] index = {1};
        bookList.stream().forEach((book) -> {
            System.out.println(index[0] + ". " + book.getTitle());
            index[0]++;});
    }

}
