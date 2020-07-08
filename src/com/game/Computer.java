package com.game;

import java.util.Random;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class Computer extends Player {
    private StackPane immediateCard;
    private Label numCards;

    public Computer(String name, int id) {
        setName(name);
        setId(id);

        numCards = new Label("x" + Integer.toString(getHand().getCards().getLength()));
        numCards.setFont(Font.font("Verdana", 20));
        numCards.setPrefWidth(64.0);
        numCards.setPrefHeight(96.0);
        numCards.setAlignment(Pos.CENTER);

        immediateCard = CardImage.getCardBack();
    }

    public StackPane getImmediateCard() {
        return immediateCard;
    }

    public Label getNumCards() {
        return numCards;
    }

    public void updateImmediateCards() {
        int handSize = getHand().getCards().getLength();
        if ( handSize == 0 ) {
            immediateCard.setVisible(false);
        }
        numCards.setText("x" + Integer.toString(handSize));
    }

    @Override
    public void playTurn() {
        for ( int i = 0; i < getHand().getLength(); i++ ) {
            Card card = getHand().getCards().getAt(i);
            if ( canPlay(card) ) {
                playCard(card);
                break;
            }
        }
    }

    @Override
    public void promptForNewColor() {
        Random rand = new Random();
        switch( rand.nextInt(4) ) {
            case 0:
            changeColor(Card.Color.RED);
            return;
            case 1:
            changeColor(Card.Color.GREEN);
            return;
            case 2:
            changeColor(Card.Color.BLUE);
            return;
            default:
            changeColor(Card.Color.YELLOW);
            return;
        }
    }
}