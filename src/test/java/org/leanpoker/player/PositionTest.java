/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;
import com.wc.poker.strategy.preflop.Position;
import com.wcs.poker.gamestate.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class PositionTest {

    private GameState gameState;
    private Position position;
    private List<Player> players;

    public PositionTest() {
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

        Player player4 = new Player();
        player4.setId(3);
        players.add(player4);

        Player player5 = new Player();
        player5.setId(4);
        players.add(player5);

        Player player6 = new Player();
        player6.setId(5);
        players.add(player6);

        Player player7 = new Player();
        player7.setId(6);
        players.add(player7);

        Player player8 = new Player();
        player8.setId(7);
        players.add(player8);

        Player player9 = new Player();
        player9.setId(8);
        players.add(player9);

        Player player10 = new Player();
        player10.setId(9);
        players.add(player10);

        gameState.setPlayers(players);
    }

    @Test
    public void shouldReturnProperNumberOfPosition() {
        gameState.setDealer(8);
        gameState.setInAction(2);
        position = new Position(gameState);
        assertEquals(4, position.getNumberOfPosition());

        gameState.setDealer(0);
        gameState.setInAction(6);
        position = new Position(gameState);
        assertEquals(6, position.getNumberOfPosition());

        gameState.setDealer(6);
        gameState.setInAction(5);
        position = new Position(gameState);
        assertEquals(9, position.getNumberOfPosition());
    }

    @Test
    public void shouldRetrunProperPositionString() {
        gameState.setDealer(8);
        gameState.setInAction(2);
        position = new Position(gameState);
        assertEquals("EP", position.getPosition());

        gameState.setDealer(4);
        gameState.setInAction(6);
        position = new Position(gameState);
        assertEquals("BB", position.getPosition());
    }
}
