package com.twu.biblioteca;

/**
 * Created by dan on 15-8-3.
 */
public class Item {
    private boolean checkedOut = false;
    private String occupant=null;

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

    public boolean isAvailable() {
        return !checkedOut;
    }

}
