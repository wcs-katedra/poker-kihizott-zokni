/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.poker.strategy;

import com.wc.poker.strategy.preflop.RangeLoader;
import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
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
public class PreFlopStrategyTest {
    
    private PreFlopStrategy pfs;
    private GameState gameState;
    private List<Player> players;
    
    public PreFlopStrategyTest() {
        
        gameState = new GameState();
        players = new ArrayList<>();
        
        List<Card> holeCards = new ArrayList<>();
        holeCards.add(new Card("A", ""));
        holeCards.add(new Card("A", ""));
        Player player1 = new Player();
        player1.setId(0);
        player1.setBet(0);
        player1.setStack(1500);
        player1.setHoleCards(holeCards);
        players.add(player1);
        
        Player player2 = new Player();
        player2.setId(1);
        players.add(player2);
        
        Player player3 = new Player();
        player3.setId(2);
        players.add(player3);
        
        gameState.setPlayers(players);
        gameState.setDealer(0);
        gameState.setInAction(0);
        gameState.setSmallBlind(10);
        gameState.setPot(0);
        gameState.setCurrentBuyIn(0);
        gameState.setMinimumRaise(30);
        
        pfs = new PreFlopStrategy(gameState);
    }
    
    @BeforeClass
    public static void setUp() {
        new RangeLoader().loadHandLists();
    }
    
    @Test
    public void testBet() {
        assertEquals(pfs.getBet(), 60);
    }
    
}
