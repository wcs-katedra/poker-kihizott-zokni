package com.wc.poker.strategy.preflop;

import com.wc.poker.strategy.preflop.enums.Actions;
import com.wc.poker.strategy.preflop.enums.Pot;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Hand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GamePhaseChecker {

	private GameState gameState;
	private Pot potstatus;

	private static List<Hand> raiseAtMiddleGamePhase = new ArrayList<>();
	private static List<Hand> reraiseAtMiddleGamePhase = new ArrayList<>();
	private static List<Hand> pushAtFinalGamePhaseLimped = new ArrayList<>();
	private static List<Hand> pushAtFinalGamePhaseRaised = new ArrayList<>();

	public GamePhaseChecker(GameState gameState) {
		this.gameState = gameState;
		potstatus = new PotStatus(gameState).getPotStatus();
	}

	public void earlyGamePhase() {
		new PositionChecker(gameState).checkPositionEGP();
	}

	public void middleGamePhase() {
		switch (potstatus) {
			case LIMPED:
			case CLEAN: {
				PreFlopStrategy.setHandsToUse(raiseAtMiddleGamePhase);
				PreFlopStrategy.setAction(Actions.RAISE);
				break;
			}
			case RAISED: {
				PreFlopStrategy.setHandsToUse(reraiseAtMiddleGamePhase);
				PreFlopStrategy.setAction(Actions.ALL_IN);
				break;
			}
		}
	}

	public void finalGamePhase() {
		switch (potstatus) {
			case LIMPED:
			case CLEAN: {
				PreFlopStrategy.setHandsToUse(pushAtFinalGamePhaseLimped);
				PreFlopStrategy.setAction(Actions.ALL_IN);
				break;
			}
			case RAISED: {
				PreFlopStrategy.setHandsToUse(pushAtFinalGamePhaseRaised);
				PreFlopStrategy.setAction(Actions.ALL_IN);
				break;
			}
		}
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public Pot getPotstatus() {
		return potstatus;
	}

	public void setPotstatus(Pot potstatus) {
		this.potstatus = potstatus;
	}

	public static List<Hand> getRaiseAtMiddleGamePhase() {
		return raiseAtMiddleGamePhase;
	}

	public static List<Hand> getReraiseAtMiddleGamePhase() {
		return reraiseAtMiddleGamePhase;
	}

	public static List<Hand> getPushAtFinalGamePhaseLimped() {
		return pushAtFinalGamePhaseLimped;
	}

	public static List<Hand> getPushAtFinalGamePhaseRaised() {
		return pushAtFinalGamePhaseRaised;
	}
}
