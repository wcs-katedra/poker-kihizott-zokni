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
public final class PreFlopStrategy {

    private boolean filled = false;
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
        if(!filled){
            loadHandLists();
        }
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
                break;
            }
            case PotStatus.raisedPot: {
                handsToUse = reraiseAtMiddleGamePhase;
                action = allin;
                break;
            }
        }
    }

    private void finalGamePhase() {
        switch (potstatus) {
            case PotStatus.limpedPot:
            case PotStatus.cleanPot: {
                handsToUse = pushAtFinalGamePhaseLimped;
                action = allin;
                break;
            }
            case PotStatus.raisedPot: {
                handsToUse = pushAtFinalGamePhaseRaised;
                action = allin;
                break;
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

    //enum ?
    public void loadHandLists() {
        List<Hand> lowPairs = new ArrayList<>();

        Hand AA = new Hand(new Card("A", ""), new Card("A", ""));
        Hand KK = new Hand(new Card("K", ""), new Card("K", ""));
        Hand QQ = new Hand(new Card("Q", ""), new Card("Q", ""));
        Hand JJ = new Hand(new Card("J", ""), new Card("J", ""));
        Hand TT = new Hand(new Card("T", ""), new Card("T", ""));
        Hand AK = new Hand(new Card("A", ""), new Card("K", ""));
        Hand AQ = new Hand(new Card("A", ""), new Card("Q", ""));
        Hand AJ = new Hand(new Card("A", ""), new Card("J", ""));
        Hand KQ = new Hand(new Card("K", ""), new Card("Q", ""));
        Hand KJ = new Hand(new Card("K", ""), new Card("J", ""));
        Hand KT = new Hand(new Card("K", ""), new Card("T", ""));
        Hand AT = new Hand(new Card("A", ""), new Card("T", ""));
        Hand Anine = new Hand(new Card("A", ""), new Card("9", ""));
        Hand Aeight = new Hand(new Card("A", ""), new Card("8", ""));
        Hand nines = new Hand(new Card("9", ""), new Card("9", ""));
        Hand eights = new Hand(new Card("8", ""), new Card("8", ""));
        Hand sevens = new Hand(new Card("7", ""), new Card("7", ""));
        Hand sixs = new Hand(new Card("6", ""), new Card("6", ""));
        Hand fives = new Hand(new Card("5", ""), new Card("5", ""));
        Hand fours = new Hand(new Card("4", ""), new Card("4", ""));
        Hand threes = new Hand(new Card("3", ""), new Card("3", ""));
        Hand twos = new Hand(new Card("2", ""), new Card("2", ""));

        lowPairs.add(twos);
        lowPairs.add(threes);
        lowPairs.add(fours);
        lowPairs.add(fives);
        lowPairs.add(sixs);
        lowPairs.add(sevens);
        lowPairs.add(eights);
        lowPairs.add(nines);

        raiseAtEarlyGamePhaseEarlyPositionLimped.add(AA);
        raiseAtEarlyGamePhaseEarlyPositionLimped.add(KK);
        raiseAtEarlyGamePhaseEarlyPositionLimped.add(QQ);
        raiseAtEarlyGamePhaseEarlyPositionLimped.add(AK);

        for (Hand lowPair : lowPairs) {
            callAtEarlyGamePhaseEarlyPositionLimped.add(lowPair);
        }
        callAtEarlyGamePhaseEarlyPositionLimped.add(TT);
        callAtEarlyGamePhaseEarlyPositionLimped.add(JJ);

        raiseAtEarlyGamePhaseEarlyPositionRaised.add(AA);
        raiseAtEarlyGamePhaseEarlyPositionRaised.add(KK);
        raiseAtEarlyGamePhaseEarlyPositionRaised.add(QQ);

        callAtEarlyGamePhaseEarlyPositionRaised.add(AK);

        for (Hand h : raiseAtEarlyGamePhaseEarlyPositionLimped) {
            raiseAtEarlyGamePhaseMiddlePositionLimped.add(h);
        }
        raiseAtEarlyGamePhaseMiddlePositionLimped.add(JJ);
        raiseAtEarlyGamePhaseMiddlePositionLimped.add(TT);

        for (Hand lowPair : lowPairs) {
            callAtEarlyGamePhaseMiddlePositionLimped.add(lowPair);
        }

        for (Hand h : raiseAtEarlyGamePhaseEarlyPositionRaised) {
            raiseAtEarlyGamePhaseMiddlePositionRaised.add(h);
        }

        callAtEarlyGamePhaseMiddlePositionRaised.add(AK);

        for (Hand h : raiseAtEarlyGamePhaseEarlyPositionLimped) {
            raiseAtEarlyGamePhaseBackPositionLimped.add(h);
        }
        raiseAtEarlyGamePhaseBackPositionLimped.add(AQ);
        raiseAtEarlyGamePhaseBackPositionLimped.add(AJ);
        raiseAtEarlyGamePhaseBackPositionLimped.add(KQ);

        for (Hand lowPair : lowPairs) {
            callAtEarlyGamePhaseBackPositionLimped.add(lowPair);
        }

        for (Hand h : raiseAtEarlyGamePhaseMiddlePositionRaised) {
            raiseAtEarlyGamePhaseBackPositionRaised.add(h);
        }
        callAtEarlyGamePhaseBackPositionRaised.add(AK);

        raiseAtMiddleGamePhase.add(AA);
        raiseAtMiddleGamePhase.add(KK);
        raiseAtMiddleGamePhase.add(QQ);
        raiseAtMiddleGamePhase.add(AK);
        raiseAtMiddleGamePhase.add(TT);
        raiseAtMiddleGamePhase.add(JJ);
        raiseAtMiddleGamePhase.add(AQ);

        reraiseAtMiddleGamePhase.add(AA);
        reraiseAtMiddleGamePhase.add(KK);
        reraiseAtMiddleGamePhase.add(QQ);
        reraiseAtMiddleGamePhase.add(JJ);
        reraiseAtMiddleGamePhase.add(AK);

        pushAtFinalGamePhaseLimped.add(AA);
        pushAtFinalGamePhaseLimped.add(KK);
        pushAtFinalGamePhaseLimped.add(QQ);
        pushAtFinalGamePhaseLimped.add(JJ);
        pushAtFinalGamePhaseLimped.add(TT);
        pushAtFinalGamePhaseLimped.add(AK);
        pushAtFinalGamePhaseLimped.add(AQ);
        pushAtFinalGamePhaseLimped.add(AJ);
        pushAtFinalGamePhaseLimped.add(AT);
        pushAtFinalGamePhaseLimped.add(Anine);
        pushAtFinalGamePhaseLimped.add(KJ);
        pushAtFinalGamePhaseLimped.add(KT);
        pushAtFinalGamePhaseLimped.add(Aeight);

        for (Hand lowPair : lowPairs) {
            pushAtFinalGamePhaseLimped.add(lowPair);
        }

        for (Hand h : pushAtFinalGamePhaseLimped) {
            pushAtFinalGamePhaseRaised.add(h);
        }
    }
}
