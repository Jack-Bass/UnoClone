package com.game;

import java.util.Stack;

import com.adt.EmptyListException;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class UnoGame {
    //variables
    public static Deck deck = new Deck();
    public static Stack<Card> discard = new Stack<>();
    public static StackPane discardGraphic = new StackPane();
    public static Label msg = new Label("Welcome to Uno!");
    public static int numDraw = 0;
    public static int skipTo = 0;
    public static boolean isReversed = false;

    public static void initDeck() {
        deck.shuffle();
    }

    public static void initDiscard() throws EmptyListException {
        Card draw = deck.draw();

        //stop action cards from starting the pile
        while ( draw.getValue().getValue() > 10 ) {
            deck.add(draw);
            draw = deck.draw();
        }

        discard.push(draw);
        CardImage.rewriteCard(discardGraphic, draw);
        discardGraphic.setVisible(true);
    }
    
    public static void resetDeck() {
        Card top = discard.pop();
        while ( !discard.empty() ) {
            deck.add(discard.pop());
        }
        deck.shuffle();
        discard.push(top);
    }

    public static void resetDiscard() {
        while ( !discard.empty() ) {
            if ( discard.peek().getValue() == Card.Value.BACK ) {
                discard.pop();
            }
            else {
                deck.add(discard.pop());
            }
        }
    }
}