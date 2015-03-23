package com.wc.strategy.preflop;

import com.wc.poker.strategy.preflop.GamePhase;
import com.wc.poker.strategy.preflop.enums.GamePhases;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class GamPhaseTest {

    private GameState gameState;
    private GamePhase gamePhase;
    private Player player;
    private List<Player> players = new ArrayList<>();

    public GamPhaseTest() {
        gameState = new GameState();
        gameState.setSmallBlind(50);
        gameState.setInAction(0);
        player = new Player();
    }

    @Before
    public void reset() {
        players.clear();
    }

    @Test
    public void testGamePhaseEvaluationForFinalPhase() {
        player.setStack(1000);
        players.add(player);
        gameState.setPlayers(players);
        gamePhase = new GamePhase(gameState);
        assertEquals(GamePhases.FINAL_PHASE, gamePhase.evaluateGamePhase());
    }

    @Test
    public void testGamePhaseEvaluationForMiddlePhase() {
        player.setStack(2000);
        players.add(player);
        gameState.setPlayers(players);
        gamePhase = new GamePhase(gameState);
        assertEquals(GamePhases.MIDDLE_PHASE, gamePhase.evaluateGamePhase());
    }

    @Test
    public void testGamePhaseEvaluationForEarlyPhase() {
        player.setStack(3000);
        players.add(player);
        gameState.setPlayers(players);
        gamePhase = new GamePhase(gameState);
        assertEquals(GamePhases.EARLY_PHASE, gamePhase.evaluateGamePhase());
    }
}
