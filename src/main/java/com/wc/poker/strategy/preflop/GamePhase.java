/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.poker.strategy.preflop;

import com.wc.poker.strategy.preflop.enums.GamePhases;
import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author Admin
 */
public class GamePhase {

	private GameState gameState;

	private int stackInBBs;

	public GamePhase(GameState gameState) {
		this.gameState = gameState;
		stackInBBs = gameState.getStackSizeInBBs();
	}

	public GamePhases evaluateGamePhase() {
		if (stackInBBs > 24) {
			return GamePhases.EARLY_PHASE;
		}
		if (stackInBBs > 13 && stackInBBs <= 24) {
			return GamePhases.MIDDLE_PHASE;
		}
		return GamePhases.FINAL_PHASE;
	}
}
