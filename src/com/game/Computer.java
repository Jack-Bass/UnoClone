package com.game;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.application.Platform;
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
        Platform.runLater(() -> {
            numCards.setText("x" + Integer.toString(handSize));
        });
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
        //find color with most cards
        int[] numEachColor = {0, 0, 0, 0}; //[Red, Green, Blue, Yellow]
        for ( int i = 0; i < getHand().getLength(); i++ ) {
            switch( getHand().getCards().getAt(i).getColor() ) {
                case RED:
                numEachColor[0]++;
                break;
                case GREEN:
                numEachColor[1]++;
                break;
                case BLUE:
                numEachColor[2]++;
                break;
                case YELLOW:
                numEachColor[3]++;
                break;
                default:
                break;
            }
        }
        //equiv to Max(1, Max(2, Max(3, 4)))
        int max = Math.max(numEachColor[0], Math.max(numEachColor[1], Math.max(numEachColor[2], numEachColor[3])));

        if ( max == numEachColor[0] ) {
            changeColor(Card.Color.RED);
        }
        else if ( max == numEachColor[1] ) {
            changeColor(Card.Color.GREEN);
        }
        else if ( max == numEachColor[2] ) {
            changeColor(Card.Color.BLUE);
        }
        else {
            changeColor(Card.Color.YELLOW);
        }
    }
}