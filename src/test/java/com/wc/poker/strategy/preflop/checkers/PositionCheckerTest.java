/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.poker.strategy.preflop.checkers;

import com.wc.poker.strategy.PreFlopStrategy;
import com.wc.poker.strategy.preflop.RangeLoader;
import com.wc.poker.strategy.preflop.enums.Positions;
import com.wc.poker.strategy.preflop.enums.Pot;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Hand;
import com.wcs.poker.gamestate.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Admin
 */
public class PositionCheckerTest {

    private GameState gameState;
    private List<Player> players;
    private PositionChecker pc;
    private PotStateChecker psc;

    public PositionCheckerTest() {
        gameState = new GameState();
        players = new ArrayList<>();

        Player player1 = new Player();
        player1.setId(0);
        players.add(player1);

        Player player2 = new Player();
        player2.setId(1);
        players.add(player2);

        Player player3 = new Player();
        player3.setId(2);
        players.add(player3);

        gameState.setPlayers(players);
        gameState.setDealer(1);
        gameState.setInAction(2);
        gameState.setSmallBlind(10);
        gameState.setPot(0);
        gameState.setCurrentBuyIn(0);

        pc = new PositionChecker(gameState);
        psc = new PotStateChecker(gameState);
    }

    @BeforeClass
    public static void setUp() {
        new RangeLoader().loadHandLists();
    }

    @Test
    public void testPostionChecker() {
        pc.setPosition(Positions.EARLY_POSITION);
        psc.setPotstatus(Pot.CLEAN);
        pc.checkPositionEGP();
        assertEquals(PreFlopStrategy.getHandsToUse(), PotStateChecker.getRaiseAtEarlyGamePhaseEarlyPositionLimped());
    }

}
