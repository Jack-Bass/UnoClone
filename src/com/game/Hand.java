package com.game;

import com.adt.CDLList;

public class Hand {
    //instance variables
    private CDLList<Card> hand;

    public Hand() {
        hand = new CDLList<>();
    }

    public int getLength() {
        return hand.getLength();
    }

    public CDLList<Card> getHand() {
        return hand;
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public CDLList<Card> emptyHand() {
        CDLList<Card> discard = new CDLList<>();

        for ( int i = 0; i < hand.getLength(); i++ ) {
            Card c = hand.getAt(0);
            discard.add(c);
            hand.delete(c);
        }

        return discard;
    }

    @Override
    public String toString() {
        String str = "";

        for ( int i = 0; i < hand.getLength(); i++ ) {
            str += hand.getAt(i).toString() + ", ";
        }

        return str;
    }
}