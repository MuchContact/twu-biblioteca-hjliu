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
        while(true){
            String next = in.nextLine();
            if(next.trim().equalsIgnoreCase("List Books")){
                System.out.println("All books are as follows:");
                List<Book> tmp = Biblioteca.getAllBooks();
                tmp.stream().forEach((book) -> {
                    System.out.println(book.getTitle());});
                continue;
            }
            if(next.trim().equalsIgnoreCase("Quit")){
                break;
            }

            System.out.println("Select a valid option!");
        }

    }

}
