package com.wcs.poker.betting;

import com.wcs.poker.betting.analysers.TablePositionAnalyser;
import com.wcs.poker.betting.handUtil.HandFinder;
import com.wcs.poker.betting.analysers.ActionAnalyser;
import com.wcs.poker.betting.analysers.BettingRoundAnalyser;
import com.wcs.poker.betting.analysers.GameStageAnalyser;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.model.*;
import com.wcs.poker.model.hands.Hand;

import java.util.List;

public class BetCalculator {

    private GameState gameState;
    private Player player;

    public BetCalculator(GameState gameState) {
        this.gameState = gameState;
        this.player = gameState.getCurrentPlayer();
    }

    public Integer calculateBet() {
        Integer bet = 0;
        ActionInTurn action = new ActionAnalyser(prepareActionAnalyserParameter()).getNextAction();
        if(action != ActionInTurn.FOLD) {
            bet = calculateBet(action);
        }
        return bet;
    }

    private Integer calculateBet(ActionInTurn action) {
        return 0;
    }

    private ActionAnalyserParameter prepareActionAnalyserParameter() {
        BettingRound bettingRound = new BettingRoundAnalyser(gameState).getBettingRound();
        GameStage gameStage = new GameStageAnalyser(gameState, player).getGameStage();
        List<Hand> possibleHands = new HandFinder(gameState).findHands();
        TablePosition tablePosition = new TablePositionAnalyser(gameState).getTablePosition();
        return new ActionAnalyserParameter(gameState, bettingRound, gameStage, possibleHands, tablePosition);
    }
}
