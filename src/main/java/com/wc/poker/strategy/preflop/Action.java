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
public class Action {

    private String action;
    private GameState gameState;

    public static final String raise = "raise";
    public static final String call = "call";
    public static final String allin = "allin";

    public Action(GameState gameState, String action) {
        this.gameState = gameState;
        this.action = action;
    }

    public int action() {
        switch (action) {
            case raise: {
                return gameState.raise(2);
            }
            case call: {
                return gameState.Call();
            }
            case allin: {
                return gameState.allIn();
            }
        }
        return 0;
    }

}
