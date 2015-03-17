/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.OrbPhase;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class OrbPhaseTest {

    private GameState gameState;
    private OrbPhase orbPhase;
    private Card card;
    private List<Card> communityCards = new ArrayList<>();

    public OrbPhaseTest() {
        gameState = new GameState();
        card = new Card();
    }

    @Before
    public void resetCards() {
        communityCards.clear();
    }

    @Test
    public void testIfOrbPhaseEqualsPreFlop() {
        gameState.setCommunityCards(communityCards);
        orbPhase = new OrbPhase(gameState);
        assertEquals("preflop", orbPhase.evaluateOrbPhase());
    }

    @Test
    public void testIfOrbPhaseEqualsFlop() {
        communityCards.add(card);
        communityCards.add(card);
        communityCards.add(card);
        gameState.setCommunityCards(communityCards);
        orbPhase = new OrbPhase(gameState);
        assertEquals("flop", orbPhase.evaluateOrbPhase());
    }

    @Test
    public void testIfOrbPhaseEqualsTurn() {
        communityCards.add(card);
        communityCards.add(card);
        communityCards.add(card);
        communityCards.add(card);
        gameState.setCommunityCards(communityCards);
        orbPhase = new OrbPhase(gameState);
        assertEquals("turn", orbPhase.evaluateOrbPhase());
    }

    @Test
    public void testIfOrbPhaseEqualsRiver() {
        communityCards.add(card);
        communityCards.add(card);
        communityCards.add(card);
        communityCards.add(card);
        communityCards.add(card);
        gameState.setCommunityCards(communityCards);
        orbPhase = new OrbPhase(gameState);
        assertEquals("river", orbPhase.evaluateOrbPhase());

    }

}
