/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.gamestate;

/**
 *
 * @author Admin
 */
public class PotStatus {

    public static final String cleanPot = "CLN";
    public static String limpedPot = "LMPD";
    public static String raisedPot = "RSD";

    private GameState gameState;
    private int buyIn;
    private int smallBlind;
    private int bigBlind;
    private int pot;

    public PotStatus(GameState gameState) {
        this.gameState = gameState;
        smallBlind = gameState.getSmallBlind();
        bigBlind = gameState.getBigBlind();
        pot = gameState.getPot();
        buyIn = gameState.getCurrentBuyIn();
    }

    public String getPotStatus() {
        if (buyIn > bigBlind) {
            return raisedPot;
        }
        if (pot == 3 * smallBlind) {
            return cleanPot;
        }
        return limpedPot;
    }
}
