package com.game;

import com.adt.CDLList;
import com.adt.EmptyListException;
import com.adt.NotInListException;

public class Hand {
    //instance variables
    private CDLList<Card> hand;

    public Hand() {
        hand = new CDLList<>();
    }

    public int getLength() {
        return hand.getLength();
    }

    public CDLList<Card> getCards() {
        return hand;
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public void emptyHand(Deck deck) {
        try {
            while ( !hand.isEmpty() ) {
                Card c = hand.getAt(0);
                hand.delete(c);
                deck.add(c);
            }
        } catch ( EmptyListException e ) {
            e.printStackTrace();
        } catch ( NotInListException n ) {
            n.printStackTrace();
        }
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