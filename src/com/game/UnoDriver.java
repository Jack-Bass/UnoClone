package com.game;

import com.adt.CDLList;

public class UnoDriver {
    public static void main(String[] args) {
        Deck d = new Deck();
        System.out.println(d.toString());
        d.shuffle();
        System.out.println(d.toString());

        CDLList<String> yeet = new CDLList<>();
        yeet.add("yeet");

        Card c = new Card(Card.Color.RED, Card.Value.FIVE);
        Card c2 = new Card(Card.Color.RED, Card.Value.TWO);
        System.out.println(c.compareTo(c2));
    }
}