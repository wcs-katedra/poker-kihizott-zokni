package com.wcs.poker.model.hands;

import java.util.List;

public class FullHouse extends Hand {

    @Override
    public List<Hand> getAllPossibleHands() {
        return null;
    }

    @Override
    public boolean canMakeAHand() {
        return false;
    }

    @Override
    public int compareTo(Hand o) {
        return 0;
    }
}
