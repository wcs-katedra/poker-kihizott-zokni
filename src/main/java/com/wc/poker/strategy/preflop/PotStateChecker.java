
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

    public static void setRaiseAtEarlyGamePhaseEarlyPositionLimped(List<Hand> raiseAtEarlyGamePhaseEarlyPositionLimped) {
        PotStateChecker.raiseAtEarlyGamePhaseEarlyPositionLimped = raiseAtEarlyGamePhaseEarlyPositionLimped;
    }

    public static List<Hand> getCallAtEarlyGamePhaseEarlyPositionLimped() {
        return callAtEarlyGamePhaseEarlyPositionLimped;
    }

    public static void setCallAtEarlyGamePhaseEarlyPositionLimped(List<Hand> callAtEarlyGamePhaseEarlyPositionLimped) {
        PotStateChecker.callAtEarlyGamePhaseEarlyPositionLimped = callAtEarlyGamePhaseEarlyPositionLimped;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseEarlyPositionRaised() {
        return raiseAtEarlyGamePhaseEarlyPositionRaised;
    }

    public static void setRaiseAtEarlyGamePhaseEarlyPositionRaised(List<Hand> raiseAtEarlyGamePhaseEarlyPositionRaised) {
        PotStateChecker.raiseAtEarlyGamePhaseEarlyPositionRaised = raiseAtEarlyGamePhaseEarlyPositionRaised;
    }

    public static List<Hand> getCallAtEarlyGamePhaseEarlyPositionRaised() {
        return callAtEarlyGamePhaseEarlyPositionRaised;
    }

    public static void setCallAtEarlyGamePhaseEarlyPositionRaised(List<Hand> callAtEarlyGamePhaseEarlyPositionRaised) {
        PotStateChecker.callAtEarlyGamePhaseEarlyPositionRaised = callAtEarlyGamePhaseEarlyPositionRaised;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseMiddlePositionLimped() {
        return raiseAtEarlyGamePhaseMiddlePositionLimped;
    }

    public static void setRaiseAtEarlyGamePhaseMiddlePositionLimped(List<Hand> raiseAtEarlyGamePhaseMiddlePositionLimped) {
        PotStateChecker.raiseAtEarlyGamePhaseMiddlePositionLimped = raiseAtEarlyGamePhaseMiddlePositionLimped;
    }

    public static List<Hand> getCallAtEarlyGamePhaseMiddlePositionLimped() {
        return callAtEarlyGamePhaseMiddlePositionLimped;
    }

    public static void setCallAtEarlyGamePhaseMiddlePositionLimped(List<Hand> callAtEarlyGamePhaseMiddlePositionLimped) {
        PotStateChecker.callAtEarlyGamePhaseMiddlePositionLimped = callAtEarlyGamePhaseMiddlePositionLimped;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseMiddlePositionRaised() {
        return raiseAtEarlyGamePhaseMiddlePositionRaised;
    }

    public static void setRaiseAtEarlyGamePhaseMiddlePositionRaised(List<Hand> raiseAtEarlyGamePhaseMiddlePositionRaised) {
        PotStateChecker.raiseAtEarlyGamePhaseMiddlePositionRaised = raiseAtEarlyGamePhaseMiddlePositionRaised;
    }

    public static List<Hand> getCallAtEarlyGamePhaseMiddlePositionRaised() {
        return callAtEarlyGamePhaseMiddlePositionRaised;
    }

    public static void setCallAtEarlyGamePhaseMiddlePositionRaised(List<Hand> callAtEarlyGamePhaseMiddlePositionRaised) {
        PotStateChecker.callAtEarlyGamePhaseMiddlePositionRaised = callAtEarlyGamePhaseMiddlePositionRaised;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseBackPositionLimped() {
        return raiseAtEarlyGamePhaseBackPositionLimped;
    }

    public static void setRaiseAtEarlyGamePhaseBackPositionLimped(List<Hand> raiseAtEarlyGamePhaseBackPositionLimped) {
        PotStateChecker.raiseAtEarlyGamePhaseBackPositionLimped = raiseAtEarlyGamePhaseBackPositionLimped;
    }

    public static List<Hand> getCallAtEarlyGamePhaseBackPositionLimped() {
        return callAtEarlyGamePhaseBackPositionLimped;
    }

    public static void setCallAtEarlyGamePhaseBackPositionLimped(List<Hand> callAtEarlyGamePhaseBackPositionLimped) {
        PotStateChecker.callAtEarlyGamePhaseBackPositionLimped = callAtEarlyGamePhaseBackPositionLimped;
    }

    public static List<Hand> getRaiseAtEarlyGamePhaseBackPositionRaised() {
        return raiseAtEarlyGamePhaseBackPositionRaised;
    }

    public static void setRaiseAtEarlyGamePhaseBackPositionRaised(List<Hand> raiseAtEarlyGamePhaseBackPositionRaised) {
        PotStateChecker.raiseAtEarlyGamePhaseBackPositionRaised = raiseAtEarlyGamePhaseBackPositionRaised;
    }

    public static List<Hand> getCallAtEarlyGamePhaseBackPositionRaised() {
        return callAtEarlyGamePhaseBackPositionRaised;
    }

    public static void setCallAtEarlyGamePhaseBackPositionRaised(List<Hand> callAtEarlyGamePhaseBackPositionRaised) {
        PotStateChecker.callAtEarlyGamePhaseBackPositionRaised = callAtEarlyGamePhaseBackPositionRaised;
    }
}
