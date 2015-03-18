package org.leanpoker.player;

import com.wcs.poker.betting.BetCalculator;
import com.wcs.poker.gamestate.GameState;

public class BetRequestHandler {

    public static int betRequest(GameState gameState) {
        return new BetCalculator(gameState).calculateBet();
    }

    public static void showdown(GameState gameState) {
    }
}
