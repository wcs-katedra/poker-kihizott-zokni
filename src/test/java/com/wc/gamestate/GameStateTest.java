/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.gamestate;

import com.wcs.poker.gamestate.Card;
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
    private Player first;
    private Player second;
    private Player third;
    private Player fourth;
    private Player fifth;
    private List<Player> players;
    private List<Card> cards;
    private Card card1;

    public GameStateTest() {
    }

    @Before
    public void initGameState() {
        players = new ArrayList<>();

        first = new Player();
        players.add(first);

        second = new Player();
        players.add(second);

        third = new Player();
        players.add(third);

        fourth = new Player();
        players.add(fourth);

        fifth = new Player();
        players.add(fifth);

        cards = new ArrayList<>();
        card1 = new Card();
        card1.setRank("4");
        card1.setSuit("hearts");
        cards.add(card1);

        gameState = new GameState();
        gameState.setPlayers(players);
        gameState.setCurrentBuyIn(240);
        gameState.setSmallBlind(100);
        gameState.setInAction(0);
    }

    @Test
    public void executeShouldReturnTheDifferencOfCurrentBuyInAndTheBetOfPlayerInAction() {
        gameState.setInAction(1);
        second.setBet(100);
        assertEquals(140, gameState.Call());
    }

    @Test
    public void exeuteShouldReturnTheActualPlayer() {
        gameState.setInAction(2);
        assertEquals(third, gameState.getActualPlayer());
    }

    @Test
    public void executeShouldReturnDoubleSmallBlindAsResult() {
        assertEquals(200, gameState.getBigBlind());
    }

    @Test
    public void executeShouldReturnStackSizeInBigBlinds() {
        first.setStack(1230);
        assertEquals(6, gameState.getStackSizeInBBs());
    }

    @Test
    public void executeShouldReturnPlayersInActionHoleCards() {
        gameState.setInAction(2);
        gameState.getActualPlayer().setHoleCards(cards);
        assertEquals(cards, gameState.getPlayerInActionHoleCards());
    }

    @Test
    public void executeShouldReturnFullStackAtRaise() {
        players.get(0).setStack(1300);
        gameState.setInAction(0);
        assertEquals(1300, gameState.allIn());
    }


    @Test
    public void executeShouldReturnTheDifferencOfCurrentBuyInAndTheBetOfPlayerInActionWithRaiseValue() {
        players.get(0).setStack(1300);
        players.get(0).setBet(50);
        gameState.setMinimumRaise(250);
        assertEquals(690, gameState.raise(2));
    }

    @After
    public void resetGameState() {
        gameState = null;
        players = null;
        first = null;
        second = null;
        third = null;
        fourth = null;
        fifth = null;
        card1 = null;
        cards = null;
    }
}
