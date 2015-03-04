/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import com.wcs.poker.gamestate.Player;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author Horváth Dániel
 */
public class GameStateTest {

    private GameState gamestate;
    private Player player;
    private List<Player> players;

    public GameStateTest() {
    }

    @Before
    public void initGameState() {
        gamestate = new GameState();
        players = new ArrayList<>();
        player = new Player();
    }

    @Test
    public void executeShouldReturnTheDifferencOfCurrentBuyInAndTheBetOfPlayerInAction() {
        player.setBet(100);
        players.add(player);
        gamestate.setPlayers(players);
        gamestate.setCurrentBuyIn(240);
        gamestate.setCurrentBuyIn(240);
        gamestate.setInAction(0);
        assertEquals(140, gamestate.getCallValue());
    }

    @Test
    public void exeuteShouldReturnTheActualPlayer() {
        players.add(new Player());
        players.add(player);
        players.add(new Player());
        gamestate.setPlayers(players);
        gamestate.setInAction(1);
        assertEquals(player, gamestate.getActualPlayer());
    }
    
    @Test
    public void executeShouldReturnDoubleSmallBlindAsResult(){
        gamestate.setSmallBlind(100);
        assertEquals(200, gamestate.getBigBlind());
    }

    @After
    public void resetGameState() {
        gamestate = null;
        players = null;
        player = null;
    }
}
