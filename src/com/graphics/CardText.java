package com.graphics;

import com.game.Card;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class CardText {
    private Text text;

    public CardText(Card card) {
        text = new Text();
        text.setFont(Font.font("Verdana", 20));
        Color c = card.getColor().toColor();
        text.setFill(c);
        text.setText(card.getValue().toString());
        text.setStroke(Color.BLACK);
    }

    public Text getLayer() {
        return text;
    }
}