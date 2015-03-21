
package com.wc.poker.strategy.preflop;

import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author Admin
 */
public class PositionChecker {

    private String position;
    private GameState gameState;

    public PositionChecker(GameState gameState) {
        this.gameState = new GameState();
        position = new Position(gameState).getPosition();
    }

    public void checkPositionEGP() {
        PotStateChecker psc = new PotStateChecker(gameState);
        switch (position) {
            case Position.earlyPosition: {
                psc.checkPotStatusEGPEP();
                break;
            }
            case Position.middlePosition: {
                psc.checkPotStatusEGPMP();
                break;
            }
            default: {
                psc.checkPotStatusEGPBP();
                break;
            }
        }
    }

}
