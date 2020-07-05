package com.game;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class CardImage {
    public static StackPane getCardFront(Card card) {
        Rectangle base = getCardBase();
        Rectangle color = getCardColor(card);
        Ellipse el = getCardEllipse();
        el.setRotate(30.0);
        Text text = getCardText(card);
        Rectangle outline = new Rectangle(60, 92, Color.TRANSPARENT);
        outline.setStroke(Color.LIGHTBLUE);
        outline.setStrokeWidth(4.0);
        outline.setVisible(false);

        StackPane sp = new StackPane();
        sp.getChildren().addAll(base, color, el, text, outline);
        return sp;
    }

    public static StackPane getCardBack() {
        Rectangle base = getCardBase();
        Rectangle color = getCardColor(new Card(Card.Color.BLACK, Card.Value.ONE));
        Text text = getCardText(new Card(Card.Color.RED,Card.Value.BACK));
        text.setRotate(-45.0);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(base, color, text);
        return sp;
    }

    public static void rewriteCard(StackPane original, Card c) {
        StackPane newCard = getCardFront(c);
        Node[] layers = newCard.getChildren().stream().toArray(Node[]::new);

        original.getChildren().clear();
        for ( int i = 0; i < layers.length; i++ ) {
            original.getChildren().add(layers[i]);
        }
    }

    private static Rectangle getCardBase() {
        return new Rectangle(64, 96, Color.WHITE);
    }

    private static Rectangle getCardColor(Card card) {
        Color c = card.getColor().toColor();
        return new Rectangle(60, 92, c);
    }

    private static Ellipse getCardEllipse() {
        Ellipse el = new Ellipse(40.0,40.0,25.0,35.0);
        el.setFill(Color.WHITE);
        return el;
    }

    private static Text getCardText(Card card) {
        Text text = new Text();
        text.setFont(Font.font("Verdana", 20));
        Color c = card.getColor().toColor();
        text.setFill(c);
        text.setText(card.getValue().toString());
        text.setStroke(Color.BLACK);
        return text;
    }
}