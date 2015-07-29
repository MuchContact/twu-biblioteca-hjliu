package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("");
        System.out.println("All books are as follows:");
        List<Book> bookList = Biblioteca.getAllBooks();
        final int[] index = {1};
        bookList.stream().forEach((book) -> {
            System.out.println(index[0] +". "+book.getTitle());
            index[0]++;});
        Scanner in = new Scanner(System.in);
        System.out.println("Operation Options: ");
        System.out.println("    1: List Books");
        System.out.println("(Notes: )");

        Customer guest = new Customer("guest");

        while(true){
            String next = in.nextLine();
            if(next.trim().equalsIgnoreCase("List Books")){
                System.out.println("All books are as follows:");
                List<Book> tmp = Biblioteca.getAllBooks();
                tmp.stream().forEach((book) -> {
                    System.out.println(book.getTitle());});
                continue;
            }
            if(next.trim().contains("checkout")){
                int bookIndex = Integer.valueOf(next.trim().substring(8).trim());
                Book book = Biblioteca.getBookByIndex(bookIndex);
                if(guest.checkout(book.getTitle())){
                    System.out.println("Thank you! Enjoy the book");
                }else{
                    System.out.println("That book is not available.");
                }
                continue;
            }
            if(next.trim().contains("return")){
                int bookIndex = Integer.valueOf(next.trim().substring(6).trim());
                Book book = Biblioteca.getBookByIndex(bookIndex);
                if(guest.returnBook(book.getTitle())){
                    System.out.println("Thank you for returning the book.");
                }else{
                    System.out.println("That is not a valid book to return.");
                }
                continue;
            }
            if(next.trim().equalsIgnoreCase("Quit")){
                break;
            }

            System.out.println("Select a valid option!");
        }

    }

}
