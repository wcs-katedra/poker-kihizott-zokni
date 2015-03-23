/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.poker.strategy.preflop.checkers;

import com.wc.poker.strategy.PreFlopStrategy;
import com.wc.poker.strategy.preflop.enums.Actions;
import com.wc.poker.strategy.preflop.RangeLoader;
import com.wc.poker.strategy.preflop.enums.Pot;
import com.wcs.poker.gamestate.GameState;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Admin
 */
public class GamePhaseCheckerTest {

    private GameState gameState;
    private GamePhaseChecker gpc;

    public GamePhaseCheckerTest() {
        gameState = new GameState();
        gameState.setSmallBlind(10);
        gameState.setPot(0);
        gameState.setCurrentBuyIn(0);
        gpc = new GamePhaseChecker(gameState);
    }

    @BeforeClass
    public static void setUp() {
        new RangeLoader().loadHandLists();
    }

    @Test
    public void testMiddleGamePhaseAtCleanPot() {
        gpc.setPotstatus(Pot.CLEAN);
        gpc.middleGamePhase();
        assertArrayEquals(PreFlopStrategy.getHandsToUse().toArray(), GamePhaseChecker.getRaiseAtMiddleGamePhase().toArray());
        assertEquals(Actions.RAISE, PreFlopStrategy.getAction());
    }

    @Test
    public void testMiddleGamePhaseAtRaisedPot() {
        gpc.setPotstatus(Pot.RAISED);
        gpc.middleGamePhase();
        assertArrayEquals(PreFlopStrategy.getHandsToUse().toArray(), GamePhaseChecker.getReraiseAtMiddleGamePhase().toArray());
        assertEquals(Actions.ALL_IN, PreFlopStrategy.getAction());
    }

    @Test
    public void testFinalGamePhaseAtCleanPot() {
        gpc.setPotstatus(Pot.CLEAN);
        gpc.finalGamePhase();
        assertArrayEquals(PreFlopStrategy.getHandsToUse().toArray(), GamePhaseChecker.getPushAtFinalGamePhaseLimped().toArray());
        assertEquals(Actions.ALL_IN, PreFlopStrategy.getAction());
    }

    @Test
    public void testFinaleGamePhaseAtRaisedPot() {
        gpc.setPotstatus(Pot.RAISED);
        gpc.finalGamePhase();
        assertArrayEquals(PreFlopStrategy.getHandsToUse().toArray(), GamePhaseChecker.getPushAtFinalGamePhaseRaised().toArray());
        assertEquals(Actions.ALL_IN, PreFlopStrategy.getAction());
    }
}
