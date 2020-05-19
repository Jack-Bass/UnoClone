package com.graphics;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class CardBase {
    private Rectangle rect;

    public CardBase() {
        rect = new Rectangle(64, 96, Color.WHITE);
    }

    public Rectangle getLayer() {
        return rect;
    }
}