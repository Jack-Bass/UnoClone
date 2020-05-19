package com.graphics;

import com.game.Card;
import javafx.scene.layout.StackPane;

public class CardBuilder {
    public StackPane getCardFront(Card card) {
        CardBase base = new CardBase();
        CardColor color = new CardColor(card);
        CardEllipse el = new CardEllipse();
        CardText text = new CardText(card);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(base.getLayer(), color.getLayer(), el.getLayer(), text.getLayer());
        return sp;
    }

    public static StackPane getCardBack() {
        CardBase base = new CardBase();
        CardColor color = new CardColor(new Card(Card.Color.BLACK, Card.Value.ONE));
        StackPane sp = new StackPane();
        sp.getChildren().addAll(base.getLayer(), color.getLayer());
        return sp;
    }
}