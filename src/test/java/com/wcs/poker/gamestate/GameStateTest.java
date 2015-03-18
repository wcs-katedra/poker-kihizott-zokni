package com.wcs.poker.gamestate;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GameStateTest {

    private GameState gameState;

    @Before
    public void initialiseGameState() {
        gameState = spy(GameState.class);
    }

    @Test
    public void shouldReturnBigBlind() {
        gameState.setSmallBlind(10);
        assertThat(gameState.getBigBlind(), is(gameState.getSmallBlind() * 2));
    }

    @Test
    public void shouldReturnCurrentPlayer() {
        Player player = new Player();
        gameState.setInAction(0);
        gameState.setPlayers(Arrays.asList(player));
        assertNotNull(gameState.getCurrentPlayer());
    }

    @Test
    public void shouldReturnHoleCardsOfCurrentPlayer() {
        Player player = spy(Player.class);
        player.setHoleCards(Arrays.asList(new Card(), new Card()));
        gameState.setPlayers(Arrays.asList(player));
        gameState.setInAction(0);
        assertNotNull(gameState.getHoleCardsOfCurrentPlayer());
    }

    @Test
    public void shouldReturnCallValue() {
        Player player = mock(Player.class);
        gameState = spy(GameState.class);
        when(player.getBet()).thenReturn(80);
        List<Player> players = Arrays.asList(player);
        gameState.setInAction(0);
        gameState.setPlayers(players);
        gameState.setCurrentBuyIn(150);
        assertThat(gameState.getCall(), is(70));
    }
}
