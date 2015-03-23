/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.poker.strategy.preflop;

import com.wc.poker.strategy.preflop.enums.OrbPhases;
import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author Admin
 */
public class OrbPhase {

	private int communityCardsNumber;

	public OrbPhase(GameState gameState) {
		communityCardsNumber = gameState.getCommunityCards().size();
	}

	public OrbPhases evaluateOrbPhase() {
		switch (communityCardsNumber) {
			case 3: {
				return OrbPhases.FLOP;
			}
			case 4: {
				return OrbPhases.TURN;
			}
			case 5: {
				return OrbPhases.RIVER;
			}
			default: {
				return OrbPhases.PRE_FLOP;
			}
		}
	}
}
