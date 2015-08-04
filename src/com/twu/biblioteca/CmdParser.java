package com.twu.biblioteca;

import com.twu.cmd.*;

/**
 * Created by dan on 15-8-4.
 */
public class CmdParser {
    private static final String LIST_BOOK = "List Books";
    private static final String SHOW_DETAIL_FOR_BOOK = "show detail for book";
    private static final String QUIT = "Quit";
    static final String RETURN_BOOK = "return --book";
    static final String CHECKOUT_BOOK = "checkout --book";
    static final String CHECKOUT_MOVIE = "checkout --movie";
    static final String RETURN_MOVIE = "return --movie";

    private boolean isValidReturnMovieCmd(String cmd) {
        return cmd.trim().contentEquals(RETURN_MOVIE);
    }

    private boolean isValidCheckoutMovieCmd(String cmd) {
        return cmd.trim().contentEquals(CHECKOUT_MOVIE);
    }

    private boolean isValidListMovieCmd(String cmd) {
        return cmd.trim().equalsIgnoreCase("List Movies");
    }

    private boolean isValidQuitAppCmd(String cmd) {
        return cmd.trim().equalsIgnoreCase(QUIT);
    }

    private boolean isValidReturnBookCmd(String cmd) {
        return cmd.trim().contains(RETURN_BOOK);
    }

    private boolean isValidCheckoutBookCmd(String cmd) {
        return cmd.trim().contains(CHECKOUT_BOOK);
    }

    private boolean isValidListBooksCmd(String cmd) {
        return cmd.trim().equalsIgnoreCase(LIST_BOOK);
    }

    private boolean isValidShowBookDetailCmd(String cmd) {
        return cmd.trim().contains(SHOW_DETAIL_FOR_BOOK);
    }

    private Integer parseBookIndex(String cmd) {
        return Integer.valueOf(cmd.trim().substring(SHOW_DETAIL_FOR_BOOK.length()).trim());
    }

    public boolean isContinueableCmd(String cmd) {
        return true;
    }

    public boolean isBreakableCmd(String cmd) {
        return false;
    }

    public Cmd parseCmd(Customer user, String cmd) {
        if(isValidListBooksCmd(cmd)){
            return new ListBooksCmd();
        }
        if(isValidShowBookDetailCmd(cmd)){
            int bookIndex = parseBookIndex(cmd);
            return new ShowBookDetailCmd(bookIndex);
        }
        if(isValidCheckoutBookCmd(cmd)) {
            int bookIndex = Integer.valueOf(cmd.trim().substring(CmdParser.CHECKOUT_BOOK.length()).trim());
            return new CheckoutBookCmd(bookIndex, user);
        }
        if(isValidReturnBookCmd(cmd)) {
            int bookIndex = Integer.valueOf(cmd.trim().substring(CmdParser.RETURN_BOOK.length()).trim());
            return new ReturnBookCmd(user, bookIndex);
        }
        if(isValidCheckoutMovieCmd(cmd)) {
            int movieIndex = Integer.valueOf(cmd.trim().substring(CmdParser.CHECKOUT_MOVIE.length()).trim());
            return new CheckoutMovieCmd(movieIndex, user);
        }
        if(isValidReturnMovieCmd(cmd)) {
            int movieIndex = Integer.valueOf(cmd.trim().substring(CmdParser.RETURN_MOVIE.length()).trim());
            return new ReturnMovieCmd(movieIndex, user);
        }
        if(isValidListMovieCmd(cmd)){
            return new ListMovieCmd();
        }
        if(isValidQuitAppCmd(cmd)) {
            return new QuitCmd();
        }
        return null;
    }
}
