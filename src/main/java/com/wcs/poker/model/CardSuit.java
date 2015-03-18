package com.wcs.poker.model;

public enum CardSuit {
    HEARTS, DIAMONDS, SPADES, CLUBS;

    public boolean isBlack() {
        return this.ordinal() > 1;
    }

    public boolean isRed() {
        return this.ordinal() <= 1;
    }
}
