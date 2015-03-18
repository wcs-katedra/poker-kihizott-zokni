package com.wcs.poker.betting;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.model.BettingRound;
import com.wcs.poker.model.GameStage;
import com.wcs.poker.model.TablePosition;
import com.wcs.poker.model.hands.Hand;

import java.util.List;

public class ActionAnalyserParameter {

    private GameState gameState;
    private BettingRound bettingRound;
    private GameStage gameStage;
    private List<Hand> possibleHands;
    private TablePosition tablePosition;

    public ActionAnalyserParameter() {}

    public ActionAnalyserParameter(GameState gameState, BettingRound bettingRound, GameStage gameStage, List<Hand> possibleHands, TablePosition tablePosition) {
        this.gameState = gameState;
        this.bettingRound = bettingRound;
        this.gameStage = gameStage;
        this.possibleHands = possibleHands;
        this.tablePosition = tablePosition;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public BettingRound getBettingRound() {
        return bettingRound;
    }

    public void setBettingRound(BettingRound bettingRound) {
        this.bettingRound = bettingRound;
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    public void setGameStage(GameStage gameStage) {
        this.gameStage = gameStage;
    }

    public List<Hand> getPossibleHands() {
        return possibleHands;
    }

    public void setPossibleHands(List<Hand> possibleHands) {
        this.possibleHands = possibleHands;
    }

    public TablePosition getTablePosition() {
        return tablePosition;
    }

    public void setTablePosition(TablePosition tablePosition) {
        this.tablePosition = tablePosition;
    }
}
