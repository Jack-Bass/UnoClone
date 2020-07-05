package com.game;

import com.adt.CDLList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import java.lang.Thread;

public class UnoApp extends Application {
    //app objects
    private Scene scene;
    private VBox vbox = new VBox();

    //game objects
    Deck deck = new Deck();
    private Button left = new Button("<");
    private Human human = new Human("HUMN", 0);
    private Button right = new Button(">");
    private Computer com1 = new Computer("COM1", 1);
    private Computer com2 = new Computer("COM2", 2);
    private Computer com3 = new Computer("COM3", 3);

    private Label msg;
    //private UnoGame game;
    private StackPane[] cardsHuman;
    private StackPane cardsCom1;
    private Label numCardsCom1;
    private StackPane cardsCom2;
    private Label numCardsCom2;
    private StackPane cardsCom3;
    private Label numCardsCom3;
    private StackPane discGraphic;

    @Override
    public void start(Stage stage) {
        vbox.setSpacing(40.0);
        initGame();

        Thread thread = new Thread(() -> {
            playGame();
        });
        thread.setDaemon(true);
        thread.start();

        //draw this bad boi
        String style = "-fx-background-color: rgba(67, 112, 53, 1);";
        scene = new Scene(vbox, 1080, 720);
        vbox.setStyle(style);
        stage.setResizable(false);
        stage.setTitle("Uno!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    private void initGame() {
        //create each component of the app
        HBox boxes = new HBox();
        VBox leftSide = new VBox();
        VBox rightSide = new VBox();
        HBox hand1 = new HBox();
        HBox hand2 = new HBox();
        HBox hand3 = new HBox();
        HBox hand4 = new HBox();

        msg = UnoGame.msg;
        msg.setFont(Font.font("Verdana", 40));
        msg.setPrefWidth(1080.0);
        msg.setAlignment(Pos.CENTER);

        boxes = new HBox();
        leftSide = new VBox();
        leftSide.setPrefWidth(540.0);
        rightSide = new VBox();
        rightSide.setAlignment(Pos.TOP_CENTER);
        rightSide.setPrefWidth(540.0);
        rightSide.setSpacing(30.0);

        cardsCom1 = com1.getImmediateCard();
        numCardsCom1 = com1.getNumCards();
        //updateImmediateCards(com1, cardsCom1);
        Label name1 = new Label(com1.getName());
        name1.setFont(Font.font("Verdana", 20));
        name1.setPrefWidth(100.0);

        cardsCom2 = com2.getImmediateCard();
        numCardsCom2 = com2.getNumCards();
        //updateImmediateCards(com2, cardsCom2);
        Label name2 = new Label(com2.getName());
        name2.setFont(Font.font("Verdana", 20));
        name2.setPrefWidth(100.0);

        cardsCom3 = com3.getImmediateCard();
        numCardsCom3 = com3.getNumCards();
        //updateImmediateCards(com3, cardsCom3);
        Label name3 = new Label(com3.getName());
        name3.setFont(Font.font("Verdana", 20));
        name3.setPrefWidth(100.0);

        cardsHuman = human.getImmediateCards();
        //updateImmediateCards();
        left.setPrefHeight(96.0);
        left.setOnMouseClicked(e -> {
            human.getHand().getCards().rewind(5);
            human.updateImmediateCards();
        });
        right.setPrefHeight(96.0);
        right.setOnMouseClicked(e -> {
            human.getHand().getCards().fastForward(5);
            human.updateImmediateCards();
        });
        Label name4 = new Label(human.getName());
        name4.setFont(Font.font("Verdana", 20));
        name4.setPrefWidth(100.0);

        Label discardLabel = new Label("Discard Pile:");
        discardLabel.setFont(Font.font("Verdana", 20));
        discGraphic = UnoGame.discardGraphic;
        discGraphic.setVisible(false);

        //add each component to the Stage
        vbox.getChildren().addAll(msg, boxes);
        boxes.getChildren().addAll(leftSide, rightSide);
        leftSide.getChildren().addAll(hand1, hand2, hand3, hand4);
        hand1.getChildren().add(name1);
        hand1.getChildren().addAll(cardsCom1, numCardsCom1);
        hand2.getChildren().add(name2);
        hand2.getChildren().addAll(cardsCom2, numCardsCom2);
        hand3.getChildren().add(name3);
        hand3.getChildren().addAll(cardsCom3, numCardsCom3);
        hand4.getChildren().add(name4);
        hand4.getChildren().add(left);
        hand4.getChildren().addAll(cardsHuman);
        hand4.getChildren().add(right);
        rightSide.getChildren().addAll(discardLabel, discGraphic);
    }

    private void playGame() {
        //game variables
        boolean isPlaying = true;
        CDLList<Player> players = new CDLList<>();
        players.add(human);
        players.add(com1);
        players.add(com2);
        players.add(com3);

        UnoGame.initDeck();
        for ( int i = 0; i < players.getLength(); i++ ) {
            players.getAt(i).initHand();
            players.getAt(i).updateImmediateCards();
        }
        UnoGame.initDiscard();

        try {
            Thread.sleep(2000);
            while ( isPlaying ) {
                //play a turn
                Player p = players.getAt(0);
                Platform.runLater(() -> {
                    msg.setText("It's " + p.getName() + "'s turn!");
                });
                Thread.sleep(1000);

                //play player's turn
                int numDraw = UnoGame.numDraw;
                if ( numDraw > 0 ) {
                    p.getHand().getCards().reorientList();
                    for ( int i = 0; i < numDraw; i++ ) {
                        if ( UnoGame.deck.isEmpty() ) {
                            UnoGame.resetDeck();
                        }
                        p.getHand().getCards().add(UnoGame.deck.draw());
                        Platform.runLater(() -> {
                            msg.setText(p.getName() + " drew " + numDraw + " cards!");
                        });
                        Thread.sleep(1000);
                    }
                    UnoGame.skipTo = 1;
                    UnoGame.numDraw = 0;
                    Platform.runLater(() -> {
                        p.updateImmediateCards();
                    });
                }
                else if ( !p.canPlayAnyCards() ) {
                    p.playFirstAvailableCard();
                }
                else {
                    p.playTurn();
                }
                Thread.sleep(1000);

                //check for win conditions
                if ( p.hasUno() ) {
                    Platform.runLater(() -> msg.setText(p.getName() + " has Uno!"));
                    Thread.sleep(1000);
                }
                if ( p.hasWon() ) {
                    Platform.runLater(() -> msg.setText(p.getName() + " WON!"));
                    isPlaying = false;
                }

                int skipTo = UnoGame.skipTo;
                if ( UnoGame.isReversed ) {
                    players.rewind(skipTo);
                }
                else {
                    players.fastForward(skipTo);
                }
            }
        } catch( InterruptedException i ) {
            i.printStackTrace();
        }
    }
}