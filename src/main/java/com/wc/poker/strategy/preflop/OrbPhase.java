/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.poker.strategy.preflop;

import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author Admin
 */
public class OrbPhase {

    private GameState gameState;
    private int communityCardsNumber;

    public OrbPhase(GameState gameState) {
        this.gameState = gameState;
        communityCardsNumber = gameState.getCommunityCards().size();
    }

    public static final String preFlop = "preflop";
    public static final String flop = "flop";
    public static final String turn = "turn";
    public static final String river = "river";

    public String evaluateOrbPhase() {
        switch (communityCardsNumber) {
            case 3: {
                return flop;
            }
            case 4: {
                return turn;
            }
            case 5: {
                return river;
            }
            default: {
                return preFlop;
            }
        }
    }
}
