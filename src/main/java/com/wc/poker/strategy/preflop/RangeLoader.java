package com.wc.poker.strategy.preflop;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Hand;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RangeLoader {

    private static List<Hand> otherHandRange = new ArrayList<>();
    private static List<Hand> pairHandRange = new ArrayList<>();

    private int range;

    public void loadHandLists() {
        loadMiddlePhaseScales();
        loadFinalPhaseScales();
        loadEarlyPhaseScales();
    }

    private void loadHandRange() {
        pairHandRange.add(new Hand(new Card("A", ""), new Card("A", "")));
        pairHandRange.add(new Hand(new Card("K", ""), new Card("K", "")));
        pairHandRange.add(new Hand(new Card("Q", ""), new Card("Q", "")));
        pairHandRange.add(new Hand(new Card("J", ""), new Card("J", "")));
        pairHandRange.add(new Hand(new Card("10", ""), new Card("10", "")));
        pairHandRange.add(new Hand(new Card("9", ""), new Card("9", "")));
        pairHandRange.add(new Hand(new Card("8", ""), new Card("8", "")));
        pairHandRange.add(new Hand(new Card("7", ""), new Card("7", "")));
        pairHandRange.add(new Hand(new Card("6", ""), new Card("6", "")));
        pairHandRange.add(new Hand(new Card("5", ""), new Card("5", "")));
        pairHandRange.add(new Hand(new Card("4", ""), new Card("4", "")));
        pairHandRange.add(new Hand(new Card("3", ""), new Card("3", "")));
        pairHandRange.add(new Hand(new Card("2", ""), new Card("2", "")));

        otherHandRange.add(new Hand(new Card("A", ""), new Card("K", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("Q", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("J", "")));
        otherHandRange.add(new Hand(new Card("K", ""), new Card("Q", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("10", "")));

        otherHandRange.add(new Hand(new Card("K", ""), new Card("J", "")));
        otherHandRange.add(new Hand(new Card("K", ""), new Card("10", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("J", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("10", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("9", "")));

        otherHandRange.add(new Hand(new Card("J", ""), new Card("10", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("8", "")));
        otherHandRange.add(new Hand(new Card("K", ""), new Card("9", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("9", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("6", "")));

        otherHandRange.add(new Hand(new Card("A", ""), new Card("5", "")));
        otherHandRange.add(new Hand(new Card("J", ""), new Card("9", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("4", "")));
        otherHandRange.add(new Hand(new Card("K", ""), new Card("8", "")));
        otherHandRange.add(new Hand(new Card("10", ""), new Card("9", "")));

        otherHandRange.add(new Hand(new Card("K", ""), new Card("7", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("3", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("8", "")));
        otherHandRange.add(new Hand(new Card("A", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("K", ""), new Card("6", "")));

        otherHandRange.add(new Hand(new Card("J", ""), new Card("8", "")));
        otherHandRange.add(new Hand(new Card("10", ""), new Card("8", "")));
        otherHandRange.add(new Hand(new Card("K", ""), new Card("5", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("7", "")));
        otherHandRange.add(new Hand(new Card("9", ""), new Card("8", "")));

        otherHandRange.add(new Hand(new Card("K", ""), new Card("4", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("6", "")));
        otherHandRange.add(new Hand(new Card("J", ""), new Card("7", "")));
        otherHandRange.add(new Hand(new Card("10", ""), new Card("7", "")));
        otherHandRange.add(new Hand(new Card("K", ""), new Card("3", "")));

        otherHandRange.add(new Hand(new Card("9", ""), new Card("7", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("5", "")));
        otherHandRange.add(new Hand(new Card("8", ""), new Card("7", "")));
        otherHandRange.add(new Hand(new Card("K", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("4", "")));

        otherHandRange.add(new Hand(new Card("J", ""), new Card("6", "")));
        otherHandRange.add(new Hand(new Card("10", ""), new Card("6", "")));
        otherHandRange.add(new Hand(new Card("8", ""), new Card("6", "")));
        otherHandRange.add(new Hand(new Card("7", ""), new Card("6", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("3", "")));

        otherHandRange.add(new Hand(new Card("J", ""), new Card("5", "")));
        otherHandRange.add(new Hand(new Card("9", ""), new Card("6", "")));
        otherHandRange.add(new Hand(new Card("Q", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("J", ""), new Card("4", "")));
        otherHandRange.add(new Hand(new Card("6", ""), new Card("5", "")));

        otherHandRange.add(new Hand(new Card("10", ""), new Card("5", "")));
        otherHandRange.add(new Hand(new Card("7", ""), new Card("5", "")));
        otherHandRange.add(new Hand(new Card("J", ""), new Card("3", "")));
        otherHandRange.add(new Hand(new Card("9", ""), new Card("5", "")));
        otherHandRange.add(new Hand(new Card("8", ""), new Card("5", "")));

        otherHandRange.add(new Hand(new Card("10", ""), new Card("4", "")));
        otherHandRange.add(new Hand(new Card("J", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("5", ""), new Card("4", "")));
        otherHandRange.add(new Hand(new Card("10", ""), new Card("3", "")));
        otherHandRange.add(new Hand(new Card("6", ""), new Card("4", "")));

        otherHandRange.add(new Hand(new Card("7", ""), new Card("4", "")));
        otherHandRange.add(new Hand(new Card("10", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("9", ""), new Card("4", "")));
        otherHandRange.add(new Hand(new Card("8", ""), new Card("4", "")));
        otherHandRange.add(new Hand(new Card("9", ""), new Card("3", "")));

        otherHandRange.add(new Hand(new Card("5", ""), new Card("3", "")));
        otherHandRange.add(new Hand(new Card("9", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("4", ""), new Card("3", "")));
        otherHandRange.add(new Hand(new Card("7", ""), new Card("3", "")));
        otherHandRange.add(new Hand(new Card("6", ""), new Card("3", "")));

        otherHandRange.add(new Hand(new Card("8", ""), new Card("3", "")));
        otherHandRange.add(new Hand(new Card("5", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("8", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("6", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("4", ""), new Card("2", "")));

        otherHandRange.add(new Hand(new Card("3", ""), new Card("2", "")));
        otherHandRange.add(new Hand(new Card("7", ""), new Card("2", "")));
    }

    private void loadMiddlePhaseScales() {
        range = (int) (otherHandRange.size() * 0.1);
        for (int i = 0; i < range; i++) {
            GamePhaseChecker.getRaiseAtMiddleGamePhase().add(otherHandRange.get(i));
        }
        range = (int) (pairHandRange.size() * 0.1);
        for (int i = 0; i < range; i++) {
            GamePhaseChecker.getRaiseAtMiddleGamePhase().add(pairHandRange.get(i));
        }

        range = (int) (otherHandRange.size() * 0.1);
        for (int i = 0; i < range; i++) {
            GamePhaseChecker.getReraiseAtMiddleGamePhase().add(otherHandRange.get(i));
        }
        range = (int) (pairHandRange.size() * 0.1);
        for (int i = 0; i < range; i++) {
            GamePhaseChecker.getReraiseAtMiddleGamePhase().add(pairHandRange.get(i));
        }
    }

    private void loadFinalPhaseScales() {
        range = (int) (otherHandRange.size() * 0.4);
        for (int i = 0; i < range; i++) {
            GamePhaseChecker.getPushAtFinalGamePhaseLimped().add(otherHandRange.get(i));
        }
        range = (int) (pairHandRange.size() * 0.1);
        for (int i = 0; i < range; i++) {
            GamePhaseChecker.getPushAtFinalGamePhaseLimped().add(pairHandRange.get(i));
        }

        range = (int) (otherHandRange.size() * 0.2);
        for (int i = 0; i < range; i++) {
            GamePhaseChecker.getPushAtFinalGamePhaseRaised().add(otherHandRange.get(i));
        }
        range = (int) (otherHandRange.size() * 0.2);
        for (int i = 0; i < range; i++) {
            GamePhaseChecker.getPushAtFinalGamePhaseRaised().add(pairHandRange.get(i));
        }
    }

    private void loadEarlyPhaseScales() {

    }
}
