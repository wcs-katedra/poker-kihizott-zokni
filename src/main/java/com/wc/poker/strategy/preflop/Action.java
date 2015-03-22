/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.poker.strategy.preflop;

import com.wc.poker.strategy.preflop.enums.Actions;
import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author Admin
 */
public class Action {

    private Actions action;
    private GameState gameState;

    public Action(GameState gameState, Actions action) {
        this.gameState = gameState;
        this.action = action;
    }

    public int action() {
        switch (action) {
            case RAISE: {
                return gameState.raise(2);
            }
            case CALL: {
                return gameState.Call();
            }
            case ALL_IN: {
                return gameState.allIn();
            }
        }
        return 0;
    }

}
