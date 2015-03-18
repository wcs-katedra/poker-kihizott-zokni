package com.wcs.poker.betting.handUtil;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.model.Card;
import com.wcs.poker.model.hands.Hand;

import java.util.List;

public class HandFinder {

    private GameState gameState;

    public HandFinder(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Hand> findHands() {
        return null;
    }

    private List<Card> getAvailableCards(GameState gameState) {
        return null;
    }
}
