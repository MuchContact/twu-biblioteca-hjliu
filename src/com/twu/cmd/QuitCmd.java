package com.twu.cmd;

/**
 * Created by dan on 15-8-4.
 */
public class QuitCmd implements Cmd {
    @Override
    public void execute() {
        System.exit(0);
    }
}
