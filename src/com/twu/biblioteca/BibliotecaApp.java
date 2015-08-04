package com.twu.biblioteca;

import com.twu.cmd.Cmd;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {


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
            CmdParser cmdParser = new CmdParser();
            Cmd command = cmdParser.parseCmd(guest, cmd);

            if(command!=null){
                command.execute();
                continue;
            }

            System.out.println("Select a valid option!");
        }

    }

    private static void printWelcome() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("");
    }

    private static void printOperationInstructions() {
        System.out.println("Operation Options: ");
        System.out.println("    1: List Books");
        System.out.println("    2: show detail for book{bookindex}");
        System.out.println("    3: return --book");
        System.out.println("    4: checkout --book");
        System.out.println("    5: checkout --movie");
        System.out.println("    6: return --movie");
        System.out.println("    7: Quit");
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
            System.out.print("login success!");
            printWelcome();
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


}
