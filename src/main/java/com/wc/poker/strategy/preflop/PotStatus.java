/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.poker.strategy.preflop;

import com.wc.poker.strategy.preflop.enums.Pot;
import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author Admin
 */
public class PotStatus {

    private int buyIn;
    private int smallBlind;
    private int bigBlind;
    private int pot;

    public PotStatus(GameState gameState) {
        smallBlind = gameState.getSmallBlind();
        bigBlind = gameState.getBigBlind();
        pot = gameState.getPot();
        buyIn = gameState.getCurrentBuyIn();
    }

    public Pot getPotStatus() {
        if (buyIn > bigBlind) {
            return Pot.RAISED;
        }
        if (pot == 3 * smallBlind) {
            return Pot.CLEAN;
        }
        return Pot.LIMPED;
    }
}
