
package com.wc.poker.strategy.preflop;

import com.wc.poker.strategy.preflop.enums.Positions;
import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author Admin
 */
public class PositionChecker {

    private Positions position;
    private GameState gameState;

    public PositionChecker(GameState gameState) {
        this.gameState = new GameState();
        position = new Position(gameState).getPosition();
    }

    public void checkPositionEGP() {
        PotStateChecker psc = new PotStateChecker(gameState);
        switch (position) {
            case EARLY_POSITION: {
                psc.checkPotStatusEGPEP();
                break;
            }
            case MIDDLE_POSITION: {
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
