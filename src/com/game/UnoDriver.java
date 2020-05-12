package com.game;

public class UnoDriver {
    public static void main(String[] args) {
        Deck d = new Deck();
        System.out.println(d.toString());
        d.shuffle();
        System.out.println(d.toString());
    }
}