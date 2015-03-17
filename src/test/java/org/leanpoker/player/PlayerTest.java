package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private List<Player> players = new ArrayList<>();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private GameState gameState = new GameState();

    public PlayerTest() {
        player1.setBet(0);
        player2.setBet(50);
        player3.setBet(100);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        gameState.setSmallBlind(50);
        gameState.setCurrentBuyIn(100);
        gameState.setMinimumRaise(100);
        gameState.setPot(150);
        gameState.setPlayers(players);
        gameState.setDealer(0);
    }

//    @Test
//    public void testBetRequest() throws Exception {
//        final GameState gameState = new GameState();
//    }
    
//    @Test
//    public void testBlindStealerStrategy() {
//        gameState.setInAction(0);
//        assertEquals(200, org.leanpoker.player.Player.betRequest(gameState));
//        gameState.setInAction(1);
//        assertEquals(150, org.leanpoker.player.Player.betRequest(gameState));
//        gameState.setInAction(2);
//        assertEquals(0, org.leanpoker.player.Player.betRequest(gameState));
//    }
}
