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
/**
 *
 * @author Horváth Dániel
 */
public class GameStateTest {

	private GameState gamestate;

	public GameStateTest() {
	}

	@Test
	public void executeShouldReturnTheDifferencOfCurrentBuyAndInAction() {
		gamestate = new GameState();
		List<Player> players = new ArrayList<Player>();
		Player player = new Player();
		player.setBet(100);
		players.add(player);
		
		gamestate.setPlayers(players);
		gamestate.setCurrentBuyIn(240);
		gamestate.setInAction(0);
		
		assertEquals(140, gamestate.getCallValue());
	}

}
