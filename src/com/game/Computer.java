package com.game;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class Computer extends Player {
    private Label numCards;
    private StackPane immediateCard;

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
}