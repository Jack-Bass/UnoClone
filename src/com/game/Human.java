package com.game;

import javafx.scene.layout.StackPane;

public class Human extends Player {
    private StackPane[] immediateCards;

    public Human(String name, int id) {
        setName(name);
        setId(id);

        immediateCards = new StackPane[5];
        for ( int i = 0; i < immediateCards.length; i++ ) {
            immediateCards[i] = CardImage.getCardBack();
        }
    }

    public StackPane[] getImmediateCards() {
        return immediateCards;
    }

    public void updateImmediateCards() {
        for ( int i = 0; i < immediateCards.length; i++ ) {
            if ( i < getHand().getLength() ) {
                Card c = getHand().getCards().getAt(i);
                CardImage.rewriteCard(immediateCards[i], c);
                immediateCards[i].setVisible(true);
            }
            else {
                immediateCards[i].setVisible(false);
            }
        }

        for ( int i = 0; i < immediateCards.length; i++ ) {
            Card card = getHand().getCards().getAt(i);
            immediateCards[i].setOnMouseClicked(e -> {
                System.out.println(card.toString());
                playCard(card);
                updateImmediateCards();
            });
        }
    }

    @Override
    public boolean isComputer() {
        return false;
    }
}