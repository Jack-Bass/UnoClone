package com.game;

import com.graphics.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class UnoApp extends Application {
    //instance variables
    private Scene scene;
    private VBox vbox = new VBox();

    @Override
    public void start(Stage stage) {
        HBox hand = new HBox();
        Card card = new Card(Card.Color.RED, Card.Value.ONE);
        Card card2 = new Card(Card.Color.GREEN, Card.Value.SKIP);
        Card card3 = new Card(Card.Color.BLUE, Card.Value.REVERSE);
        Card card4 = new Card(Card.Color.YELLOW, Card.Value.DRAW2);
        Card card5 = new Card(Card.Color.BLACK, Card.Value.WILD);
        Card card6 = new Card(Card.Color.BLACK, Card.Value.DRAW4);
        CardBuilder cb = new CardBuilder();
        hand.getChildren().add(cb.getCardFront(card));
        hand.getChildren().add(cb.getCardFront(card2));
        hand.getChildren().add(cb.getCardFront(card3));
        hand.getChildren().add(cb.getCardFront(card4));
        hand.getChildren().add(cb.getCardFront(card5));
        hand.getChildren().add(cb.getCardFront(card6));
        vbox.getChildren().addAll(hand);

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
}