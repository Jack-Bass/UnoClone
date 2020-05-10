package com.game;

public class Card {
    //enums
    public enum Color {
        RED, GREEN, BLUE, YELLOW, BLACK
    }

    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, 
        SKIP, REVERSE, DRAW2, WILD, DRAW4
    }

    //instance variables
    private Color color;
    private Value value;

    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    public boolean equals(Card c) {
        return ((color == c.color) && (value == c.value));
    }

    @Override
    public String toString() {
        return color + "." + value;
    }
}