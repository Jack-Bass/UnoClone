package com.game;

public class UnoDriver {
    public static void main(String[] args) {
        Card c = new Card(Card.Color.RED, Card.Value.ONE);
        System.out.println(c.toString());
    }
}