package com.game;

import java.util.Stack;

abstract class Player implements Comparable<Player> {
    private String name;
    private int id;
    private Hand hand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hand getHand() {
        return hand;
    }

    public void returnToDeck(Deck d) {
        Stack<Card> discard = hand.emptyHand();

        while ( !discard.empty() ) {
            Card c = discard.pop();
            d.add(c);
        }
    }

    public boolean hasUno() {
        return (hand.getLength() == 1);
    }

    public boolean hasWon() {
        return (hand.getLength() == 0);
    }

    @Override
    public int compareTo(Player p) {
        return Integer.compare(id, p.getId());
    }
}