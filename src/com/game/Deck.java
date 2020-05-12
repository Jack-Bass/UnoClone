package com.game;

import java.util.Random;

public class Deck {
    //instance variables
    private Card.Color[] colors = Card.Color.values();
    private Card.Value[] values = Card.Value.values();
    private Card[] deck;
    private int numCards;

    public Deck() {
        deck = new Card[108];
        numCards = 0;

        //create deck
        for ( int i = 0; i < 4; i++ ) {
            for ( int j = 0; j < 13; j++ ) {
                Card c = new Card(colors[i], values[j]);

                //each color only has one 0
                if ( j == 0 ) {
                    deck[numCards] = c;
                }
                //each color has two of other cards
                else {
                    deck[numCards] = c;
                    numCards++;
                    deck[numCards] = c;
                }
                numCards++;
            }
        }
        //four of each Wild and Draw4
        for ( int j = 13; j <= 14; j++ ) {
            Card c = new Card(colors[4], values[j]);
            deck[numCards] = c;
            deck[numCards+1] = c;
            deck[numCards+2] = c;
            deck[numCards+3] = c;
            numCards += 4;
        }
    }

    public boolean isEmpty() {
        return (deck.length == 0);
    }

    public boolean isFull() {
        return (deck.length == 108);
    }

    public Card draw() {
        if ( isEmpty() ) {
            throw new UnsupportedOperationException();
        }

        //return first card to Player
        Card c = deck[0];
        //resize deck
        Card[] newDeck = new Card[deck.length-1];
        for ( int i = 1; i < deck.length; i++ ) {
            newDeck[i-1] = deck[i];
        }
        deck = newDeck;

        numCards--;
        return c;
    }

    public void shuffle() {
        Random rand = new Random();
        int numSwaps = 432;
        for ( int i = 0; i < numSwaps; i++ ) {
            swap(rand.nextInt(deck.length), rand.nextInt(deck.length));
        }
    }

    private void swap(int a, int b) {
        Card temp = deck[a];
        deck[a] = deck[b];
        deck[b] = temp;
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