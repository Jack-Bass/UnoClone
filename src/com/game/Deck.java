package com.game;

public class Deck {
    //instance variables
    private Card.Color[] colors = Card.Color.values();
    private Card.Value[] values = Card.Value.values();
    private Card[] deck;
    //private ArrayList<Card> deck;

    public Deck() {
        deck = new Card[108];

        //create deck
        int index = 0;
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 13; j++ ) {
                Card c = new Card(colors[i], values[j]);

                //each color only has one 0
                if ( j == 0 ) {
                    deck[index] = c;
                }
                //each color has two of other cards
                else {
                    deck[index] = c;
                    index++;
                    deck[index] = c;
                }
                index++;
            }
        }
        //four of each Wild and Draw4
        for ( int j = 13; j <= 14; j++ ) {
            Card c = new Card(colors[4], values[j]);
            deck[index] = c;
            deck[index+1] = c;
            deck[index+2] = c;
            deck[index+3] = c;
            index += 4;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for ( int i = 0; i < deck.length; i++ ) {
            str += deck[i].toString() + "\n";
        }
        return str;
    }
}