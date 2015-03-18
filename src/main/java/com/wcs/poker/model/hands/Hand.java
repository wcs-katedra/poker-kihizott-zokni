package com.wcs.poker.model.hands;

import com.wcs.poker.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public abstract boolean isAHand();
}
