package com.game;

import com.adt.EmptyListException;
import com.adt.NotInListException;
import javafx.application.Platform;

abstract class Player extends UnoGame implements Comparable<Player> {
    private String name;
    private int id;
    private Hand hand = new Hand();

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

    public void initHand() throws EmptyListException {
        for ( int i = 0; i < 7; i++ ) {
            hand.addCard(deck.draw());
        }
    }

    public boolean isComputer() {
        return true;
    }

    abstract void updateImmediateCards();

    abstract void playTurn();

    abstract void promptForNewColor();

    public void returnCardsToDeck() {
        hand.emptyHand(deck);
    }

    public boolean canPlay(Card c) {
        Card top = discard.peek();
        if ( c.getColor() == top.getColor() || c.getValue() == top.getValue() ) {
            return true;
        }
        else if ( c.getColor() == top.getColor() && top.getValue() == Card.Value.BACK ) {
            return true;
        }
        else if ( c.getColor() == Card.Color.BLACK ) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean canPlayAnyCards() {
        for ( int i = 0; i < hand.getLength(); i++ ) {
            Card card = hand.getCards().getAt(i);
            if ( canPlay(card) ) {
                return true;
            }
        }
        return false;
    }

    public void playFirstAvailableCard() {
        try {
            if ( deck.isEmpty() ) {
                resetDeck();
            }
            Card c = deck.draw();
            hand.getCards().add(c);
            while ( !canPlay(c) ) {
                if ( deck.isEmpty() ) {
                    resetDeck();
                }
                c = deck.draw();
                hand.getCards().add(c);
            }
            playCard(c);
        } catch(EmptyListException e) {
            e.printStackTrace();
        }
    }

    public void changeColor(Card.Color newColor) {
        try {
            Platform.runLater(() -> {
                msg.setText("Changed color to " + newColor.toString());
            });
            Thread.sleep(2000);

            //add dummy card to top of pile
            discard.push(new Card(newColor, Card.Value.BACK));
        } catch( InterruptedException i ) {
            i.printStackTrace();
        }
    }

    public void playCard(Card c) {
        try {
            Platform.runLater(() -> {
                try {
                    msg.setText(name + " plays " + c.toString());
                    hand.getCards().delete(c);
                    updateImmediateCards();
                    discard.push(c);
                    CardImage.rewriteCard(discardGraphic, c);
                } catch(NotInListException n) {
                    n.printStackTrace();
                } catch(EmptyListException e) {
                    e.printStackTrace();
                }
            });
            //see if dummy card is on top
            if ( discard.peek().getValue() == Card.Value.BACK ) {
                discard.pop();
            }

            //perform cards action
            skipTo = 0;
            if ( c.getColor() == Card.Color.BLACK ) {
                promptForNewColor();
                if ( c.getValue() == Card.Value.DRAW4 ) {
                    numDraw = 4;
                }
            }
            else if ( c.getValue() == Card.Value.DRAW2 ) {
                numDraw = 2;
            }
            else if ( c.getValue() == Card.Value.SKIP ) {
                skipTo++;
            }
            else if ( c.getValue() == Card.Value.REVERSE ) {
                isReversed = !isReversed;
            }
            else {
                //do nothing for normal cards
            }
            skipTo++;

            Thread.sleep(2000);
        } catch( InterruptedException i ) {
            i.printStackTrace();
        }
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
}