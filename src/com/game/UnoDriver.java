package com.game;

import com.adt.CDLList;

public class UnoDriver {
    public static void main(String[] args) {
        /*
        Deck d = new Deck();
        System.out.println(d.toString());
        d.shuffle();
        System.out.println(d.toString());
        */

        CDLList<Card> yeet = new CDLList<>();
        yeet.add(new Card(Card.Color.RED, Card.Value.ONE));
        yeet.printList();
        yeet.add(new Card(Card.Color.RED, Card.Value.ONE));
        yeet.printList();
        yeet.add(new Card(Card.Color.BLUE, Card.Value.ONE));
        yeet.printList();
        yeet.add(new Card(Card.Color.RED, Card.Value.TWO));
        yeet.printList();
        yeet.add(new Card(Card.Color.RED, Card.Value.ZERO));
        yeet.printList();
        yeet.add(new Card(Card.Color.GREEN, Card.Value.ONE));
        yeet.printList();
        yeet.printList();
        yeet.printList();
        Card card = new Card(Card.Color.RED, Card.Value.ONE);
        yeet.delete(card);
        yeet.printList();
        yeet.printList();
    }
}