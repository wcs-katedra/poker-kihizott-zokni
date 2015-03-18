package com.wcs.poker.model.hands;

import com.wcs.poker.model.Card;

import java.util.List;

public abstract class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public abstract List<Hand> getAllPossibleHands();

    public abstract boolean canMakeAHand();
}
