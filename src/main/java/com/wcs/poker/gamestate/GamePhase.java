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
public class GamePhase {

    private GameState gameState;

    public static final String earlyGamePhase = "early";
    public static final String middleGamePhase = "middle";
    public static final String finalGamePhase = "final";

    public GamePhase(GameState gameState) {
        this.gameState = gameState;
    }

    public String evaluateGamePhase() {
        if (gameState.getStackSizeInBBs() > 24) {
            return earlyGamePhase;
        }
        if (gameState.getStackSizeInBBs() > 13 && gameState.getStackSizeInBBs() <= 24) {
            return middleGamePhase;
        }
        return finalGamePhase;
    }
}
