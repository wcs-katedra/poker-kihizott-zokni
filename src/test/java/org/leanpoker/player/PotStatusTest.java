/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.PotStatus;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class PotStatusTest {

    private GameState gameState;
    private PotStatus potStatus;

    public PotStatusTest() {
        gameState = new GameState();
        gameState.setCurrentBuyIn(200);
        gameState.setSmallBlind(100);
        gameState.setPot(300);
        potStatus = new PotStatus(gameState);
    }

    @Test
    public void executeShouldReturnProperPotStatus() {
        assertEquals("CLN", potStatus.getPotStatus());
        
        gameState.setPot(500);
        potStatus = new PotStatus(gameState);
        assertEquals("LMPD", potStatus.getPotStatus());
        
        gameState.setCurrentBuyIn(400);
        gameState.setPot(500);
        potStatus = new PotStatus(gameState);
        assertEquals("RSD", potStatus.getPotStatus());
    }
}
