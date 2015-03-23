package com.wc.poker.strategy;

import com.wc.poker.strategy.preflop.Action;
import com.wc.poker.strategy.preflop.GamePhase;
import com.wc.poker.strategy.preflop.checkers.GamePhaseChecker;
import com.wc.poker.strategy.preflop.enums.Actions;
import com.wc.poker.strategy.preflop.enums.GamePhases;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Hand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public final class PreFlopStrategy {

    private GameState gameState;
    private GamePhases gamePhase;

    private Hand hand;

    private static Actions action;
    private static List<Hand> handsToUse = new ArrayList<>();

    public PreFlopStrategy(GameState gameState) {
        this.gameState = gameState;
        gamePhase = new GamePhase(gameState).evaluateGamePhase();
        hand = gameState.getHand();
    }

    public int getBet() {
        checkGamePhase();
        for (Hand handToUse : handsToUse) {
            if (hand.rankEquals(handToUse)) {
                return new Action(gameState, action).action();
            }
        }
        return 0;
    }

    public void checkGamePhase() {
        GamePhaseChecker gpc = new GamePhaseChecker(gameState);
        switch (gamePhase) {
            case EARLY_PHASE: {
                gpc.earlyGamePhase();
                break;
            }
            case MIDDLE_PHASE: {
                gpc.middleGamePhase();
                break;
            }
            case FINAL_PHASE: {
                gpc.finalGamePhase();
                break;
            }
        }
    }

    public static void setHandsToUse(List<Hand> handsToUse) {
        PreFlopStrategy.handsToUse = handsToUse;
    }

    public static List<Hand> getHandsToUse() {
        return handsToUse;
    }

    public static void setAction(Actions action) {
        PreFlopStrategy.action = action;
    }

    public static Actions getAction() {
        return action;
    }
}
