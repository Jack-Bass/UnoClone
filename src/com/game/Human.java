package com.game;

import javafx.scene.layout.StackPane;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class Human extends Player {
    private StackPane[] immediateCards;
    private boolean canClick;

    public Human(String name, int id) {
        setName(name);
        setId(id);
        canClick = true;

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
            Card c = getHand().getCards().getAt(i);
            immediateCards[i].setOnMouseClicked(e -> {
                if ( canClick ) {
                    if ( canPlay(c) ) {
                        playCard(c);
                        canClick = false;
                        updateImmediateCards();
                    }
                    else {
                        Platform.runLater(() -> {
                            msg.setText("Cannot play " + c.toString());
                        });
                    }
                }
            });
        }
    }

    @Override
    public void playTurn() {
        canClick = true;

        while ( canClick ) {
            //this method will only exit if I print something
            System.out.print("");
            if ( !canClick ) {
                return;
            }
        }
    }

    @Override
    public void promptForNewColor() {
        if ( Platform.isFxApplicationThread() ) {
            promptPlayer();
            return;
        }

        //see if latching helps
        final CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            try {
                promptPlayer();
            } finally {
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch ( InterruptedException i ) {
            //wait
        }
    }

    private void promptPlayer() {
        //create options
        ButtonType red = new ButtonType("Red");
        ButtonType green = new ButtonType("Green");
        ButtonType blue = new ButtonType("Blue");
        ButtonType yellow = new ButtonType("Yellow");

        //create Alert box
        Alert option = new Alert(Alert.AlertType.CONFIRMATION);
        option.setContentText("Pick a new color.");
        option.getButtonTypes().setAll(red, green, blue, yellow);
        
        Optional<ButtonType> choice = option.showAndWait();
        if ( choice.get() == red ) {
            changeColor(Card.Color.RED);
        }
        else if ( choice.get() == green ) {
            changeColor(Card.Color.GREEN);
        }
        else if ( choice.get() == blue ) {
            changeColor(Card.Color.BLUE);
        }
        else {
            changeColor(Card.Color.YELLOW);
        }
    }

    @Override
    public boolean isComputer() {
        return false;
    }
}