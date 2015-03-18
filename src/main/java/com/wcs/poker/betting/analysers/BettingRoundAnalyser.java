package com.wcs.poker.betting.analysers;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.model.BettingRound;

public class BettingRoundAnalyser {

    private GameState gameState;

    public BettingRoundAnalyser(GameState gameState) {
        this.gameState = gameState;
    }


    public BettingRound getBettingRound() {
        return BettingRound.PRE_FLOP;
    }
}
