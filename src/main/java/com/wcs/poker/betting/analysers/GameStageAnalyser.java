package com.wcs.poker.betting.analysers;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.model.GameStage;
import com.wcs.poker.model.Player;

public class GameStageAnalyser {

    private GameState gameState;
    private Player player;

    public GameStageAnalyser(GameState gameState, Player player) {
        this.gameState = gameState;
        this.player = player;
    }


    public GameStage getGameStage() {
        return GameStage.WE_HAVE_MORE_THAN_12_BIG_BLIND;
    }
}
