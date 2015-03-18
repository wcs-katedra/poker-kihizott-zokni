package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.DefaultStrategy;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private DefaultStrategy strategy;

    private List<Player> players = new ArrayList<>();
    private List<Card> holeCards = new ArrayList<>();
    private Card card1;
    private Card card2;
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player player3 = new Player();
    private Player player4 = new Player();
    private Player player5 = new Player();
    private Player player6 = new Player();
    private Player player7 = new Player();
    private Player player8 = new Player();
    private GameState gameState = new GameState();

    public PlayerTest() {

        player1.setStack(1000);
        player1.setId(0);
        player2.setStack(3000);
        player2.setId(1);
        player3.setStack(3000);
        player3.setId(2);
        player4.setStack(3000);
        player4.setId(3);
        player5.setStack(3000);
        player5.setId(4);
        player6.setStack(3000);
        player6.setId(5);
        player7.setStack(3000);
        player7.setId(6);
        player8.setStack(3000);
        player8.setId(7);

        player1.setBet(0);
        player2.setBet(50);
        player3.setBet(100);

        card1 = new Card("A", "");
        card2 = new Card("A", "");
        holeCards.add(card1);
        holeCards.add(card2);
        player1.setHoleCards(holeCards);

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        players.add(player7);
        players.add(player8);

        gameState.setSmallBlind(50);
        gameState.setCurrentBuyIn(100);
        gameState.setMinimumRaise(100);
        gameState.setPot(150);
        gameState.setPlayers(players);
        gameState.setDealer(0);
        gameState.setInAction(0);
    }

    @Test
    public void testPreFlopStrategy() {
        strategy = new DefaultStrategy(gameState);
        assertEquals(1000, strategy.betRequest());
    }
}
