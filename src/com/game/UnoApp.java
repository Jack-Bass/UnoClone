package com.game;

//import com.graphics.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;

public class UnoApp extends Application {
    //instance variables
    private Scene scene;
    private VBox vbox = new VBox();

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        //StackPane[][] cards = new StackPane[7][16];
        int index = 0;
        Deck d = new Deck();
        for ( int i = 0; i < 16; i++ ) {
            for ( int j = 0; j < 7; j++ ) {
                if ( index < 108 ) {
                    StackPane stk = CardBuilder.getCardFront(d.draw());
                    grid.add(stk, i, j);
                    index++;
                }
            }
        }
        grid.add(CardBuilder.getCardBack(), 15, 3);
        vbox.getChildren().add(grid);

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