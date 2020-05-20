package com.game;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.StackPane;

public class CardBuilder {
    public static StackPane getCardFront(Card card) {
        Rectangle base = getCardBase();
        Rectangle color = getCardColor(card);
        Ellipse el = getCardEllipse();
        Text text = getCardText(card);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(base, color, el, text);
        return sp;
    }

    public static StackPane getCardBack() {
        Rectangle base = getCardBase();
        Rectangle color = getCardColor(new Card(Card.Color.BLACK, Card.Value.ONE));
        StackPane sp = new StackPane();
        sp.getChildren().addAll(base, color);
        return sp;
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