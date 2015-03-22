package com.wc.poker.strategy.preflop;

import com.wc.poker.strategy.preflop.enums.Positions;
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
    private Positions position;
    private int positionNumber;

    public Position(GameState gameState) {
        this.gameState = gameState;
        players = gameState.getPlayers();
        numberOfPlayers = players.size();
        activePlayer = gameState.getInAction();
        dealer = gameState.getDealer();
    }

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
                position = Positions.SMALL_BLIND;
                break;
            }
            case 2: {
                position = Positions.BIG_BLIND;
                break;
            }
            case 3:
            case 4:
            case 5: {
                position = Positions.EARLY_POSITION;
                break;
            }
            case 6:
            case 7:
            case 8: {
                position = Positions.MIDDLE_POSITION;
                break;
            }
            case 9:
            case 0: {
                position = Positions.BACK_POSITION;
                break;
            }
        }
    }

    public void evaluatePositionAtNinePlayer() {
        switch (positionNumber) {
            case 1: {
                position = Positions.SMALL_BLIND;
                break;
            }
            case 2: {
                position = Positions.BIG_BLIND;
                break;
            }
            case 3:
            case 4: {
                position = Positions.EARLY_POSITION;
                break;
            }
            case 5:
            case 6:
            case 7: {
                position = Positions.MIDDLE_POSITION;
                break;
            }
            case 8:
            case 0: {
                position = Positions.BACK_POSITION;
                break;
            }
        }
    }

    public void evaluatePositionAtEightPlayer() {
        switch (positionNumber) {
            case 1: {
                position = Positions.SMALL_BLIND;
                break;
            }
            case 2: {
                position = Positions.BIG_BLIND;
                break;
            }
            case 3: {
                position = Positions.EARLY_POSITION;
                break;
            }
            case 4:
            case 5:
            case 6: {
                position = Positions.MIDDLE_POSITION;
                break;
            }
            case 7:
            case 0: {
                position = Positions.BACK_POSITION;
                break;
            }
        }
    }

    public void evaluatePositionAtSevenPlayer() {
        switch (positionNumber) {
            case 1: {
                position = Positions.SMALL_BLIND;
                break;
            }
            case 2: {
                position = Positions.BIG_BLIND;
                break;
            }
            case 3:
            case 4:
            case 5: {
                position = Positions.MIDDLE_POSITION;
                break;
            }
            case 6:
            case 0: {
                position = Positions.BACK_POSITION;
                break;
            }
        }
    }

    public void evaluatePositionAtSixPlayer() {
        switch (positionNumber) {
            case 1: {
                position = Positions.SMALL_BLIND;
                break;
            }
            case 2: {
                position = Positions.BIG_BLIND;
                break;
            }
            case 3:
            case 4: {
                position = Positions.MIDDLE_POSITION;
                break;
            }
            case 5:
            case 0: {
                position = Positions.BACK_POSITION;
                break;
            }
        }
    }

    public void evaluatePositionAtFivePlayer() {
        switch (positionNumber) {
            case 1: {
                position = Positions.SMALL_BLIND;
                break;
            }
            case 2: {
                position = Positions.BIG_BLIND;
                break;
            }
            case 3: {
                position = Positions.MIDDLE_POSITION;
                break;
            }
            case 4:
            case 0: {
                position = Positions.BACK_POSITION;
                break;
            }
        }
    }

    public void evaluatePositionAtFourPlayer() {
        switch (positionNumber) {
            case 1: {
                position = Positions.SMALL_BLIND;
                break;
            }
            case 2: {
                position = Positions.BIG_BLIND;
                break;
            }
            case 3:
            case 0: {
                position = Positions.BACK_POSITION;
                break;
            }
        }
    }

    public void evaluatePositionAtThreePlayer() {
        switch (positionNumber) {
            case 1: {
                position = Positions.SMALL_BLIND;
                break;
            }
            case 2: {
                position = Positions.BIG_BLIND;
                break;
            }
            case 0: {
                position = Positions.BACK_POSITION;
                break;
            }
        }
    }

    public void evaluatePositionAtTwoPlayer() {
        switch (positionNumber) {
            case 1: {
                position = Positions.SMALL_BLIND;
                break;
            }
            case 0: {
                position = Positions.BIG_BLIND;
                break;
            }
        }
    }

    public Positions getPosition() {
        getNumberOfPosition();
        evaluatePosition();
        return position;
    }
}
