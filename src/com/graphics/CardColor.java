package com.graphics;

import com.game.Card;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class CardColor {
    private Rectangle rect;

    public CardColor(Card card) {
        Color c = card.getColor().toColor();
        rect = new Rectangle(60, 92, c);
    }

    public Rectangle getLayer() {
        return rect;
    }
}