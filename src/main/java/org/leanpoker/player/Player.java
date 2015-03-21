package org.leanpoker.player;

import com.wc.poker.strategy.DefaultStrategy;
import com.wcs.poker.gamestate.GameState;

public class Player {

    static final String VERSION = "Blind Stealer player";

    public static int betRequest(GameState gameState) {
        return new DefaultStrategy(gameState).betRequest();
    }

    public static void showdown(GameState gameState) {
        
    }
}
