
package com.wc.poker.strategy.preflop;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Hand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PotStateChecker {

    private GameState gameState;
    private String potstatus;

    private static List<Hand> raiseAtEarlyGamePhaseEarlyPositionLimped = new ArrayList<>();
    private static List<Hand> callAtEarlyGamePhaseEarlyPositionLimped = new ArrayList<>();
    private static List<Hand> raiseAtEarlyGamePhaseEarlyPositionRaised = new ArrayList<>();
    private static List<Hand> callAtEarlyGamePhaseEarlyPositionRaised = new ArrayList<>();

    private static List<Hand> raiseAtEarlyGamePhaseMiddlePositionLimped = new ArrayList<>();
    private static List<Hand> callAtEarlyGamePhaseMiddlePositionLimped = new ArrayList<>();
    private static List<Hand> raiseAtEarlyGamePhaseMiddlePositionRaised = new ArrayList<>();
    private static List<Hand> callAtEarlyGamePhaseMiddlePositionRaised = new ArrayList<>();

    private static List<Hand> raiseAtEarlyGamePhaseBackPositionLimped = new ArrayList<>();
    private static List<Hand> callAtEarlyGamePhaseBackPositionLimped = new ArrayList<>();
    private static List<Hand> raiseAtEarlyGamePhaseBackPositionRaised = new ArrayList<>();
    private static List<Hand> callAtEarlyGamePhaseBackPositionRaised = new ArrayList<>();

    public PotStateChecker(GameState gameState) {
        this.gameState = gameState;
        potstatus = new PotStatus(gameState).getPotStatus();
    }

    public void checkPotStatusEGPEP() {
        switch (potstatus) {
            case PotStatus.cleanPot:
            case PotStatus.limpedPot: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseEarlyPositionLimped);
                PreFlopStrategy.setAction(Action.raise);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseEarlyPositionLimped);
                    PreFlopStrategy.setAction(Action.call);
                }
                break;
            }
            case PotStatus.raisedPot: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseEarlyPositionRaised);
                PreFlopStrategy.setAction(Action.raise);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseEarlyPositionRaised);
                    PreFlopStrategy.setAction(Action.call);
                }
                break;
            }
        }
    }

    public void checkPotStatusEGPMP() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseMiddlePositionLimped);
                PreFlopStrategy.setAction(Action.raise);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseMiddlePositionLimped);
                    PreFlopStrategy.setAction(Action.call);
                }
                break;
            }
            case PotStatus.raisedPot: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseMiddlePositionRaised);
                PreFlopStrategy.setAction(Action.raise);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseMiddlePositionRaised);
                    PreFlopStrategy.setAction(Action.call);
                }
                break;
            }
        }
    }

    public void checkPotStatusEGPBP() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseBackPositionLimped);
                PreFlopStrategy.setAction(Action.raise);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseBackPositionLimped);
                    PreFlopStrategy.setAction(Action.call);
                }
                break;
            }
            case PotStatus.raisedPot: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseBackPositionRaised);
                PreFlopStrategy.setAction(Action.raise);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseBackPositionRaised);
                    PreFlopStrategy.setAction(Action.call);
                }
                break;
            }
        }
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseEarlyPositionLimped() {
        return raiseAtEarlyGamePhaseEarlyPositionLimped;
    }

    public static List<Hand> getCallAtEarlyGamePhaseEarlyPositionLimped() {
        return callAtEarlyGamePhaseEarlyPositionLimped;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseEarlyPositionRaised() {
        return raiseAtEarlyGamePhaseEarlyPositionRaised;
    }

    public static List<Hand> getCallAtEarlyGamePhaseEarlyPositionRaised() {
        return callAtEarlyGamePhaseEarlyPositionRaised;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseMiddlePositionLimped() {
        return raiseAtEarlyGamePhaseMiddlePositionLimped;
    }

    public static List<Hand> getCallAtEarlyGamePhaseMiddlePositionLimped() {
        return callAtEarlyGamePhaseMiddlePositionLimped;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseMiddlePositionRaised() {
        return raiseAtEarlyGamePhaseMiddlePositionRaised;
    }

    public static List<Hand> getCallAtEarlyGamePhaseMiddlePositionRaised() {
        return callAtEarlyGamePhaseMiddlePositionRaised;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseBackPositionLimped() {
        return raiseAtEarlyGamePhaseBackPositionLimped;
    }

    public static List<Hand> getCallAtEarlyGamePhaseBackPositionLimped() {
        return callAtEarlyGamePhaseBackPositionLimped;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseBackPositionRaised() {
        return raiseAtEarlyGamePhaseBackPositionRaised;
    }
    
    public static List<Hand> getCallAtEarlyGamePhaseBackPositionRaised() {
        return callAtEarlyGamePhaseBackPositionRaised;
    }
}
