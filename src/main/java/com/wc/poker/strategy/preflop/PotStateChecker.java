
package com.wc.poker.strategy.preflop;

import com.wc.poker.strategy.preflop.enums.Actions;
import com.wc.poker.strategy.preflop.enums.Pot;
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
    private Pot potstatus;

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
            case CLEAN:
            case LIMPED: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseEarlyPositionLimped);
                PreFlopStrategy.setAction(Actions.RAISE);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseEarlyPositionLimped);
                    PreFlopStrategy.setAction(Actions.CALL);
                }
                break;
            }
            case RAISED: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseEarlyPositionRaised);
                PreFlopStrategy.setAction(Actions.RAISE);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseEarlyPositionRaised);
                    PreFlopStrategy.setAction(Actions.CALL);
                }
                break;
            }
        }
    }

    public void checkPotStatusEGPMP() {
        switch (potstatus) {
            case LIMPED:
            case CLEAN: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseMiddlePositionLimped);
                PreFlopStrategy.setAction(Actions.RAISE);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseMiddlePositionLimped);
                    PreFlopStrategy.setAction(Actions.CALL);
                }
                break;
            }
            case RAISED: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseMiddlePositionRaised);
                PreFlopStrategy.setAction(Actions.RAISE);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseMiddlePositionRaised);
                    PreFlopStrategy.setAction(Actions.CALL);
                }
                break;
            }
        }
    }

    public void checkPotStatusEGPBP() {
        switch (potstatus) {
            case LIMPED:
            case CLEAN: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseBackPositionLimped);
                PreFlopStrategy.setAction(Actions.RAISE);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseBackPositionLimped);
                    PreFlopStrategy.setAction(Actions.CALL);
                }
                break;
            }
            case RAISED: {
                PreFlopStrategy.setHandsToUse(raiseAtEarlyGamePhaseBackPositionRaised);
                PreFlopStrategy.setAction(Actions.RAISE);
                if (PreFlopStrategy.getHandsToUse().isEmpty()) {
                    PreFlopStrategy.setHandsToUse(callAtEarlyGamePhaseBackPositionRaised);
                    PreFlopStrategy.setAction(Actions.CALL);
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
