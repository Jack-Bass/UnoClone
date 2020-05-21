package com.game;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class UnoApp extends Application {
    //instance variables
    private Scene scene;
    private VBox vbox = new VBox();

    @Override
    public void start(Stage stage) {
        vbox.setSpacing(40.0);
        Label msg = new Label("Welcome to Uno!");
        msg.setFont(Font.font("Verdana", 40));
        msg.setPrefWidth(1080.0);
        msg.setAlignment(Pos.CENTER);
        HBox boxes = new HBox();
        VBox leftSide = new VBox();
        leftSide.setPrefWidth(540.0);
        VBox rightSide = new VBox();
        rightSide.setAlignment(Pos.TOP_CENTER);
        rightSide.setPrefWidth(540.0);
        rightSide.setSpacing(30.0);
        HBox hand1 = new HBox();
        StackPane[] cards1 = new StackPane[5];
        Label name1 = new Label("COM1:");
        name1.setFont(Font.font("Verdana", 20));
        name1.setPrefWidth(100.0);
        for ( int i = 0; i < 5; i++ ) {
            cards1[i] = CardBuilder.getCardBack();
            /*
            if ( i > 0 ) {
                cards1[i].setVisible(false);
            }
            */
        }
        HBox hand2 = new HBox();
        StackPane[] cards2 = new StackPane[5];
        Label name2 = new Label("COM2:");
        name2.setFont(Font.font("Verdana", 20));
        name2.setPrefWidth(100.0);
        //cards2[0] = CardBuilder.getCardBack();
        for ( int i = 0; i < 5; i++ ) {
            cards2[i] = CardBuilder.getCardBack();
            if ( i > 0 ) {
                cards2[i].setVisible(false);
            }
        }
        HBox hand3 = new HBox();
        StackPane[] cards3 = new StackPane[5];
        Label name3 = new Label("COM3:");
        name3.setFont(Font.font("Verdana", 20));
        name3.setPrefWidth(100.0);
        //cards3[0] = CardBuilder.getCardBack();
        for ( int i = 0; i < 5; i++ ) {
            cards3[i] = CardBuilder.getCardBack();
            if ( i > 0 ) {
                cards3[i].setVisible(false);
            }
        }
        HBox hand4 = new HBox();
        Button left = new Button("<");
        left.setPrefHeight(96.0);
        Button right = new Button(">");
        right.setPrefHeight(96.0);
        StackPane[] cards4 = new StackPane[5];
        Label name4 = new Label("HUMN:");
        name4.setFont(Font.font("Verdana", 20));
        name4.setPrefWidth(100.0);
        //cards4[0] = CardBuilder.getCardFront(new Card(Card.Color.BLUE, Card.Value.TWO));
        for ( int i = 0; i < 5; i++ ) {
            cards4[i] = CardBuilder.getCardBack();
            if ( i > 0 ) {
                cards4[i].setVisible(false);
            }
        }
        Label drawLabel = new Label("Draw Pile:");
        drawLabel.setFont(Font.font("Verdana", 20));
        StackPane draw = new StackPane();
        draw = CardBuilder.getCardBack();
        Label discardLabel = new Label("Discard Pile:");
        discardLabel.setFont(Font.font("Verdana", 20));
        StackPane discard = new StackPane();
        discard  = CardBuilder.getCardBack();
        discard.setVisible(false);

        vbox.getChildren().addAll(msg, boxes);
        boxes.getChildren().addAll(leftSide, rightSide);
        leftSide.getChildren().addAll(hand1, hand2, hand3, hand4);
        hand1.getChildren().add(name1);
        hand1.getChildren().addAll(cards1);
        hand2.getChildren().add(name2);
        hand2.getChildren().addAll(cards2);
        hand3.getChildren().add(name3);
        hand3.getChildren().addAll(cards3);
        hand4.getChildren().add(name4);
        hand4.getChildren().add(left);
        hand4.getChildren().addAll(cards4);
        hand4.getChildren().add(right);
        rightSide.getChildren().addAll(drawLabel, draw, discardLabel, discard);

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