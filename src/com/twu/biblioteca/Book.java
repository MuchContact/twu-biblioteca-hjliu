package com.twu.biblioteca;

/**
 * Created by dan on 15-7-28.
 */
public class Book {
    private final String title;
    private final String author;
    private final int publishedYear;
    private boolean checkedOut = false;
    private String occupant=null;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public boolean isAvailable() {
        return !checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public boolean checkout(String username) {
        if(checkedOut){
            return false;
        }
        checkedOut = true;
        this.occupant = username;
        return true;
    }

    public boolean return2Biblioteca(String username) {
        if(this.occupant!=null && this.occupant.equals(username)){
            checkedOut = false;
            this.occupant = null;
            return true;
        }
        return false;
    }
}