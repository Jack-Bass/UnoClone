package com.game;

import javafx.scene.layout.StackPane;
import javafx.scene.Node;
/*
import javafx.scene.paint.Color;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
*/
import javafx.scene.control.Label;

abstract class Player implements Comparable<Player> {
    private String name;
    private int id;
    private Hand hand = new Hand();

    public static Label msg = new Label("Welcome to Uno!");

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

    public boolean isComputer() {
        return true;
    }

    abstract void updateImmediateCards();

    /*
    public StackPane[] getImmediateCards() {
        return immediateCards;
    }

    public void updateImmediateCards() {
        try {
            for ( int i = 0; i < immediateCards.length; i++ ) {
                if ( i < hand.getLength() ) {
                    //immediateCards[i].getChildren().clear();
                    Card c = hand.getCards().getAt(i);
                    CardImage ci = new CardImage(c);
                    //immediateCards[i] = CardBuilder.getCardFront(c);
                    //CardBuilder.rewriteCard(immediateCards[i], CardBuilder.getCardFront(c));
                    immediateCards[i] = (new CardImage(ci)).getCardImage();
                    immediateCards[i].setVisible(true);
                }
                else {
                    immediateCards[i].setVisible(false);
                }
            }

            if ( !isComputer() ) {
                for ( int i = 0; i < immediateCards.length; i++ ) {
                    Card card = hand.getCards().getAt(i);
                    immediateCards[i].setOnMouseClicked(e -> {
                        System.out.println(card.toString());
                        playCard(card);
                        updateImmediateCards();
                    });
                }
            }
        } catch( NullPointerException n ) {
            immediateCards = new StackPane[5];
            for ( int i = 0; i < immediateCards.length; i++ ) {
                //immediateCards[i] = CardBuilder.getCardBack();
                immediateCards[i] = (new CardImage()).getCardImage();
            }
        }
    }
    */

    public void playCard(Card c) {
        getHand().getCards().delete(c);
        msg.setText(c.toString());
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

    public static Label getMessage() {
        return msg;
    }
}