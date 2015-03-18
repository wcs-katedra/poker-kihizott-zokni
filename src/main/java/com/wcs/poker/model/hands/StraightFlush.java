package com.wcs.poker.model.hands;

public class StraightFlush extends Hand {

    @Override
    public boolean isAHand() {
        return false;
    }

    @Override
    public int compareTo(Hand o) {
        return 0;
    }
}
