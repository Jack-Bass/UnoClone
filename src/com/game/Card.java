package com.game;

public class Card implements Comparable<Card> {
    //enums
    public enum Color {
        RED(0), GREEN(1), BLUE(2), YELLOW(3), BLACK(4);

        private int value;
        private Color(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Value {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), 
        SKIP(10), REVERSE(11), DRAW2(12), WILD(13), DRAW4(14);

        private int value;
        private Value(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
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

    @Override
    public int compareTo(Card c) {
        if ( this.color.getValue() < c.color.getValue() ) {
            return -1;
        }
        else if ( this.color.getValue() == c.color.getValue() ) {
            if ( this.value.getValue() < c.value.getValue() ) {
                return -1;
            }
            else if ( this.value.getValue() == c.value.getValue() ) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }
}