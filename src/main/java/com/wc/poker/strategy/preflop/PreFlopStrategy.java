
package com.wc.poker.strategy.preflop;

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
    private String gamePhase;
    
    private Hand hand;
    
    private static String action;
    private static List<Hand> handsToUse = new ArrayList<>();

    public PreFlopStrategy(GameState gameState) {
        this.gameState = gameState;
        gamePhase = new GamePhase(gameState).evaluateGamePhase();
        loadHand();
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
            case GamePhase.earlyGamePhase: {
                gpc.earlyGamePhase();
                break;
            }
            case GamePhase.middleGamePhase: {
                gpc.middleGamePhase();
                break;
            }
            case GamePhase.finalGamePhase: {
                gpc.finalGamePhase();
                break;
            }
        }
    }

    private void loadHand() {
        if (hand != null) {
            hand = gameState.getHand();
        }
    }

    public static void setHandsToUse(List<Hand> handsToUse) {
        PreFlopStrategy.handsToUse = handsToUse;
    }

    public static List<Hand> getHandsToUse() {
        return handsToUse;
    }

    public static void setAction(String action) {
        PreFlopStrategy.action = action;
    }
}
