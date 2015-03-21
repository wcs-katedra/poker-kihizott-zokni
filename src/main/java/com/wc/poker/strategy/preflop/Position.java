package com.wc.poker.strategy.preflop;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Position {

    private GameState gameState;
    private int activePlayer;
    private int dealer;
    private List<Player> players;
    private int numberOfPlayers;
    private String position;
    private int positionNumber;

    public Position(GameState gameState) {
        this.gameState = gameState;
        players = gameState.getPlayers();
        numberOfPlayers = players.size();
        activePlayer = gameState.getInAction();
        dealer = gameState.getDealer();
    }

    public static final String smallBlind = "SB";
    public static final String bigBlind = "BB";
    public static final String earlyPosition = "EP";
    public static final String middlePosition = "MP";
    public static final String backPosition = "BP";

    public int getNumberOfPosition() {
        //átrendezzük a listát úgy hogy a dealer legyen a 0. index
        while (players.get(0).getId() != dealer) {
            players.add(players.get(0));
            players.remove(0);
        }
        positionNumber = 0;
        // megnézzük hogy a listában hányadik az aktív player az lesz a pozíciója
        for (Player player : players) {
            if (player.getId() != activePlayer) {
                positionNumber++;
            }
            if (player.getId() == activePlayer) {
                return positionNumber;
            }
        }
        return -1;
    }

    public void evaluatePosition() {
        switch (numberOfPlayers) {
            case 10: {
                evaluatePositionAtTenPlayer();
                break;
            }
            case 9: {
                evaluatePositionAtNinePlayer();
                break;
            }
            case 8: {
                evaluatePositionAtEightPlayer();
                break;
            }
            case 7: {
                evaluatePositionAtSevenPlayer();
                break;
            }
            case 6: {
                evaluatePositionAtSixPlayer();
                break;
            }
            case 5: {
                evaluatePositionAtFivePlayer();
                break;
            }
            case 4: {
                evaluatePositionAtFourPlayer();
                break;
            }
            case 3: {
                evaluatePositionAtThreePlayer();
                break;
            }
            case 2: {
                evaluatePositionAtTwoPlayer();
                break;
            }
        }
    }

    public void evaluatePositionAtTenPlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 2: {
                position = bigBlind;
                break;
            }
            case 3:
            case 4:
            case 5: {
                position = earlyPosition;
                break;
            }
            case 6:
            case 7:
            case 8: {
                position = middlePosition;
                break;
            }
            case 9:
            case 0: {
                position = backPosition;
                break;
            }
        }
    }

    public void evaluatePositionAtNinePlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 2: {
                position = bigBlind;
                break;
            }
            case 3:
            case 4: {
                position = earlyPosition;
                break;
            }
            case 5:
            case 6:
            case 7: {
                position = middlePosition;
                break;
            }
            case 8:
            case 0: {
                position = backPosition;
                break;
            }
        }
    }

    public void evaluatePositionAtEightPlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 2: {
                position = bigBlind;
                break;
            }
            case 3: {
                position = earlyPosition;
                break;
            }
            case 4:
            case 5:
            case 6: {
                position = middlePosition;
                break;
            }
            case 7:
            case 0: {
                position = backPosition;
                break;
            }
        }
    }

    public void evaluatePositionAtSevenPlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 2: {
                position = bigBlind;
                break;
            }
            case 3:
            case 4:
            case 5: {
                position = middlePosition;
                break;
            }
            case 6:
            case 0: {
                position = backPosition;
                break;
            }
        }
    }

    public void evaluatePositionAtSixPlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 2: {
                position = bigBlind;
                break;
            }
            case 3:
            case 4: {
                position = middlePosition;
                break;
            }
            case 5:
            case 0: {
                position = backPosition;
                break;
            }
        }
    }

    public void evaluatePositionAtFivePlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 2: {
                position = bigBlind;
                break;
            }
            case 3: {
                position = middlePosition;
                break;
            }
            case 4:
            case 0: {
                position = backPosition;
                break;
            }
        }
    }

    public void evaluatePositionAtFourPlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 2: {
                position = bigBlind;
                break;
            }
            case 3:
            case 0: {
                position = backPosition;
                break;
            }
        }
    }

    public void evaluatePositionAtThreePlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 2: {
                position = bigBlind;
                break;
            }
            case 0: {
                position = backPosition;
                break;
            }
        }
    }

    public void evaluatePositionAtTwoPlayer() {
        switch (positionNumber) {
            case 1: {
                position = smallBlind;
                break;
            }
            case 0: {
                position = bigBlind;
                break;
            }
        }
    }

    public String getPosition() {
        getNumberOfPosition();
        evaluatePosition();
        return position;
    }
}
