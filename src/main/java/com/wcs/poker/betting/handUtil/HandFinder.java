package com.wcs.poker.betting.handUtil;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.model.Card;
import com.wcs.poker.model.hands.Hand;
import com.wcs.poker.model.hands.HighCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandFinder {

    private GameState gameState;

    public HandFinder(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Hand> findHands() {
        List<Card> availableCards = getAvailableCards(gameState);
        return calculateHandValues(availableCards);
    }

    private List<Hand> calculateHandValues(List<Card> availableCards) {
        List<Hand> hands = new ArrayList<>();
        List<HighCard> highCards = getAllHandsOfGivenType(HighCard.class, availableCards);
        return hands;
    }

    private <T extends Hand> List<T> getAllHandsOfGivenType(Class<T> handType, List<Card> availableCards) {
        return Collections.emptyList();
    }

    private List<Card> getAvailableCards(GameState gameState) {
        List<Card> availableCards = new ArrayList<>(gameState.getCommunityCards());
        availableCards.addAll(gameState.getHoleCardsOfCurrentPlayer());
        return availableCards;
    }
}
