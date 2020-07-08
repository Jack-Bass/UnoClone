package com.game;

import javafx.application.Application;

public class UnoDriver {
    public static void main(String[] args) {
        try {
            Application.launch(UnoApp.class, args);
        } catch (UnsupportedOperationException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}