package com.graphics;

import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;

public class CardEllipse {
    private Ellipse el;

    public CardEllipse() {
        el = new Ellipse(40.0,40.0,25.0,35.0);
        el.setFill(Color.WHITE);
    }

    public Ellipse getLayer() {
        return el;
    }
}