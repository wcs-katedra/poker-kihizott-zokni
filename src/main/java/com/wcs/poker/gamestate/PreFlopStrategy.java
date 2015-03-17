/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.gamestate;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PreFlopStrategy {

    private GameState gameState;
    private String gamePhase;
    private String position;
    private String potstatus;

    public final String raise = "raise";
    public final String call = "call";
    public final String allin = "allin";

    private Hand hand;

    private List<Hand> handsToUse;
    private String action;

    public PreFlopStrategy(GameState gameState) {
        this.gameState = gameState;
        gamePhase = new GamePhase(gameState).evaluateGamePhase();
        position = new Position(gameState).getPosition();
        potstatus = new PotStatus(gameState).getPotStatus();
        hand = new Hand(gameState.getActualPlayer().getHoleCards().get(0), gameState.getActualPlayer().getHoleCards().get(1));
        handsToUse = new ArrayList<>();
    }

    private static List<Hand> raiseAtMiddleGamePhase;
    private static List<Hand> reraiseAtMiddleGamePhase;
    private static List<Hand> pushAtFinalGamePhaseLimped;
    private static List<Hand> pushAtFinalGamePhaseRaised;
    private static List<Hand> raiseAtEarlyGamePhaseEarlyPositionLimped;
    private static List<Hand> callAtEarlyGamePhaseEarlyPositionLimped;
    private static List<Hand> raiseAtEarlyGamePhaseEarlyPositionRaised;
    private static List<Hand> callAtEarlyGamePhaseEarlyPositionRaised;
    private static List<Hand> raiseAtEarlyGamePhaseMiddlePositionLimped;
    private static List<Hand> callAtEarlyGamePhaseMiddlePositionLimped;
    private static List<Hand> raiseAtEarlyGamePhaseMiddlePositionRaised;
    private static List<Hand> callAtEarlyGamePhaseMiddlePositionRaised;
    private static List<Hand> raiseAtEarlyGamePhaseBackPositionLimped;
    private static List<Hand> callAtEarlyGamePhaseBackPositionLimped;
    private static List<Hand> raiseAtEarlyGamePhaseBackPositionRaised;
    private static List<Hand> callAtEarlyGamePhaseBackPositionRaised;

    public int getBet() {
        checkGamePhase();
        for (Hand handToUse : handsToUse) {
            if (hand.rankEquals(handToUse)) {
                return action();
            }
        }
        return 0;
    }

    public void checkGamePhase() {
        switch (gamePhase) {
            case GamePhase.earlyGamePhase: {
                earlyGamePhase();
                break;
            }
            case GamePhase.middleGamePhase: {
                middleGamePhase();
                break;
            }
            case GamePhase.finalGamePhase: {
                finalGamePhase();
                break;
            }
        }
    }

    private void earlyGamePhase() {
        checkPositionEGP();
    }

    private void middleGamePhase() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                handsToUse = raiseAtMiddleGamePhase;
                action = raise;
            }
            case PotStatus.raisedPot: {
                handsToUse = reraiseAtMiddleGamePhase;
                action = allin;
            }
        }
    }

    private void finalGamePhase() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                handsToUse = pushAtFinalGamePhaseLimped;
                action = allin;
            }
            case PotStatus.raisedPot: {
                handsToUse = pushAtFinalGamePhaseRaised;
                action = allin;
            }
        }
    }

    private void checkPositionEGP() {
        switch (position) {
            case Position.earlyPosition: {
                checkPotStatusEGPEP();
                break;
            }
            case Position.middlePosition: {
                checkPotStatusEGPMP();
                break;
            }
            default: {
                checkPotStatusEGPBP();
                break;
            }
        }
    }

    private void checkPotStatusEGPEP() {
        switch (potstatus) {
            case PotStatus.cleanPot:
            case PotStatus.limpedPot: {
                handsToUse = raiseAtEarlyGamePhaseEarlyPositionLimped;
                action = raise;
                if (handsToUse.isEmpty()) {
                    handsToUse = callAtEarlyGamePhaseEarlyPositionLimped;
                    action = call;
                }
                break;
            }
            case PotStatus.raisedPot: {
                handsToUse = raiseAtEarlyGamePhaseEarlyPositionRaised;
                action = raise;
                if (handsToUse.isEmpty()) {
                    handsToUse = callAtEarlyGamePhaseEarlyPositionRaised;
                    action = call;
                }
                break;
            }
        }
    }

    private void checkPotStatusEGPMP() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                handsToUse = raiseAtEarlyGamePhaseMiddlePositionLimped;
                action = raise;
                if (handsToUse.isEmpty()) {
                    handsToUse = callAtEarlyGamePhaseMiddlePositionLimped;
                    action = call;
                }
                break;
            }
            case PotStatus.raisedPot: {
                handsToUse = raiseAtEarlyGamePhaseMiddlePositionRaised;
                action = raise;
                if (handsToUse.isEmpty()) {
                    handsToUse = callAtEarlyGamePhaseMiddlePositionRaised;
                    action = call;
                }
                break;
            }
        }
    }

    private void checkPotStatusEGPBP() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                handsToUse = raiseAtEarlyGamePhaseBackPositionLimped;
                action = raise;
                if (handsToUse.isEmpty()) {
                    handsToUse = callAtEarlyGamePhaseBackPositionLimped;
                    action = call;
                }
                break;
            }
            case PotStatus.raisedPot: {
                handsToUse = raiseAtEarlyGamePhaseBackPositionRaised;
                action = raise;
                if (handsToUse.isEmpty()) {
                    handsToUse = callAtEarlyGamePhaseBackPositionRaised;
                    action = call;
                }
                break;
            }
        }
    }

    public int action() {
        switch (action) {
            case raise: {
                gameState.raise(2);
                break;
            }
            case call: {
                gameState.Call();
                break;
            }
            case allin: {
                gameState.allIn();
                break;
            }
        }
        return 0;
    }

    public void loadHandLists() {

    }
}
