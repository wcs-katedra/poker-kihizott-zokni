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
public class DefaultStrategy {

    private GameState gameState;
    private String orbPhase;

    private int bet;

    public DefaultStrategy(GameState gameState) {
        this.gameState = gameState;
        orbPhase = new OrbPhase(gameState).evaluateOrbPhase();
    }

    public int betRequest() {
        buildScale();
        return bet;
    }

    public void buildScale() {
        switch (orbPhase) {
            case OrbPhase.preFlop: {
                preFlopStrategy();
                break;
            }
            case OrbPhase.flop: {
                flopStrategy();
                break;
            }
            case OrbPhase.turn: {
                turnStrategy();
                break;
            }
            case OrbPhase.river: {
                riverStrategy();
                break;
            }
        }
    }

    public void preFlopStrategy() {
        bet =  new PreFlopStrategy(gameState).getBet();
    }

    public void flopStrategy() {
        bet = gameState.raise(1);
    }

    public void turnStrategy() {
        bet = gameState.raise(1);
    }

    private void riverStrategy() {
        bet = gameState.Call();
    }
}
