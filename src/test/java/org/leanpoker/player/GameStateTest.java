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

    private GameState gameState;
    private Player player;
    private List<Player> players;

    public GameStateTest() {
    }

    @Before
    public void initGameState() {
        gameState = new GameState();
        players = new ArrayList<>();
        player = new Player();
    }

    @Test
    public void executeShouldReturnTheDifferencOfCurrentBuyInAndTheBetOfPlayerInAction() {
        player.setBet(100);
        players.add(player);
        gameState.setPlayers(players);
        gameState.setCurrentBuyIn(240);
        gameState.setCurrentBuyIn(240);
        gameState.setInAction(0);
        assertEquals(140, gameState.getCallValue());
    }

    @Test
    public void exeuteShouldReturnTheActualPlayer() {
        players.add(new Player());
        players.add(player);
        players.add(new Player());
        gameState.setPlayers(players);
        gameState.setInAction(1);
        assertEquals(player, gameState.getActualPlayer());
    }

    @Test
    public void executeShouldReturnDoubleSmallBlindAsResult() {
        gameState.setSmallBlind(100);
        assertEquals(200, gameState.getBigBlind());
    }

    @Test
    public void executeShouldReturnStackSizeInBigBlinds() {
        gameState.setSmallBlind(50);
        player.setStack(1230);
        players.add(player);
        gameState.setPlayers(players);
        gameState.setInAction(0);
        assertEquals(12, gameState.getStackSizeInBBs());
    }

    @After
    public void resetGameState() {
        gameState = null;
        players = null;
        player = null;
    }
}
