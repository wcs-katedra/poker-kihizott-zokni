package com.wcs.poker.betting.analysers;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.model.TablePosition;


public class TablePositionAnalyser {

    private GameState gameState;

    public TablePositionAnalyser(GameState gameState) {
        this.gameState = gameState;
    }

    public TablePosition getTablePosition() {
        return TablePosition.BLIND;
    }
}
