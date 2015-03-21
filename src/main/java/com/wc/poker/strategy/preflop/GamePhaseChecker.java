package com.wc.poker.strategy.preflop;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Hand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GamePhaseChecker {

    private GameState gameState;
    private String potstatus;

    private static List<Hand> raiseAtMiddleGamePhase = new ArrayList<>();
    private static List<Hand> reraiseAtMiddleGamePhase = new ArrayList<>();
    private static List<Hand> pushAtFinalGamePhaseLimped = new ArrayList<>();
    private static List<Hand> pushAtFinalGamePhaseRaised = new ArrayList<>();

    public GamePhaseChecker(GameState gameState) {
        this.gameState = gameState;
        potstatus = new PotStatus(gameState).getPotStatus();
    }

    public void earlyGamePhase() {
        new PositionChecker(gameState).checkPositionEGP();
    }

    public void middleGamePhase() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                PreFlopStrategy.setHandsToUse(raiseAtMiddleGamePhase);
                PreFlopStrategy.setAction(Action.raise);
                break;
            }
            case PotStatus.raisedPot: {
                PreFlopStrategy.setHandsToUse(reraiseAtMiddleGamePhase);
                PreFlopStrategy.setAction(Action.allin);
                break;
            }
        }
    }

    public void finalGamePhase() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                PreFlopStrategy.setHandsToUse(pushAtFinalGamePhaseLimped);
                PreFlopStrategy.setAction(Action.allin);
                break;
            }
            case PotStatus.raisedPot: {
                PreFlopStrategy.setHandsToUse(pushAtFinalGamePhaseRaised);
                PreFlopStrategy.setAction(Action.allin);
                break;
            }
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public String getPotstatus() {
        return potstatus;
    }

    public void setPotstatus(String potstatus) {
        this.potstatus = potstatus;
    }

    public static List<Hand> getRaiseAtMiddleGamePhase() {
        return raiseAtMiddleGamePhase;
    }

    public static List<Hand> getReraiseAtMiddleGamePhase() {
        return reraiseAtMiddleGamePhase;
    }

    public static List<Hand> getPushAtFinalGamePhaseLimped() {
        return pushAtFinalGamePhaseLimped;
    }

    public static List<Hand> getPushAtFinalGamePhaseRaised() {
        return pushAtFinalGamePhaseRaised;
    }
}
