package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Hand;
import java.util.List;

public class Player {

    static final String VERSION = "Default Java folding player";

    //több mint 24 nagyvakunk van, belső pozícióban vagyunk és még senki sem emelt, ezekkel fogunk emelni
    private static List<Hand> earlyRaiseFromMiddleCards;
    //több mint 24 nagyvakunk van, belső pozícióban vagyunk és még senki sem emelt, ezekkel fogunk limpelni (megadjuk a nagyvak tétet)
    private static List<Hand> earlyLimpFromMiddleCards;

    //több mint 24 nagyvakunk van, hátsó pozícióban vagyunk (CO BU SB BB) és még senki sem emelt, ezekkel fogunk emelni
    private static List<Hand> earlyRaiseFromBackOrBlindsCards;
    //több mint 24 nagyvakunk van hátsó pozícióban vagyunk (CO BU SB SB) és még senki sem emelt, ezekkel fogunk limpelni
    private static List<Hand> earlyLimpFromBackOrBlindsCards;

    //több mint 24 nagyvakunk van hátsó pozícióban vagyunk és emelés történt ezekkel a fogjuk callazni az emelést
    private static List<Hand> earlyCallFromBackOrBlindsCards;
    //több mint 24 nagyvakunk van hátsó pozícióban vagyunk és emelés történt ezekkel a lapokkal visszaemelünk

    private static List<Hand> earlyreraiseFromBackOrBlindsCards;
    //13-23 nagyvakunk van és nem emelt senki ezekkel a lapokkal emelünk
    private List<Hand> midRaiseCards;
    //13-23 nagyvakunk van és emeltek elöttünk - a következő lapokkal all-in megyünk

    private List<Hand> midReRaiseCards;
    //13> nagyvakunk van és nem emelt senki - a következő lapokkal all-in
    private List<Hand> finalPushAtLimpedPotCards;
    //13> nagyvakunk van és emeltek elöttünk - a következő lapokkal all-in
    private List<Hand> finalPushAtRaisedPotCards;

    public static int betRequest(GameState gameState) {
        switch (gameState.evaluateRacePhase()) {
            case "EARLY": {
                switch (gameState.getPosition()) {
                    case "MP": {
                        for (Hand hand : earlyRaiseFromMiddleCards) {
                            if (hand.equals(gameState.getPlayerInActionHoleCards())) {
                                return gameState.getCurrentBuyIn() + gameState.getBigBlind();
                            }
                        }
                        for (Hand hand : earlyLimpFromMiddleCards) {
                            if (hand.equals(gameState.getPlayerInActionHoleCards())) {
                                return gameState.getCurrentBuyIn();
                            }
                        }
                        break;
                    }
                    default: {
                        switch (gameState.getPotStatus()) {
                            case "RSD": {
                                for (Hand hand : earlyCallFromBackOrBlindsCards) {
                                    if (hand.equals(gameState.getPlayerInActionHoleCards())) {
                                        return gameState.getCurrentBuyIn();
                                    }
                                }
                                for (Hand hand : earlyreraiseFromBackOrBlindsCards) {
                                    if (hand.equals(gameState.getPlayerInActionHoleCards())) {
                                        return gameState.getPlayers().get(gameState.getInAction()).getStack();
                                    }
                                }
                                break;
                            }
                            default: {
                                for (Hand hand : earlyRaiseFromBackOrBlindsCards) {
                                    if (hand.equals(gameState.getPlayerInActionHoleCards())) {
                                        return gameState.getCurrentBuyIn() + gameState.getBigBlind();
                                    }
                                }
                                for (Hand hand : earlyLimpFromBackOrBlindsCards) {
                                    if (hand.equals(gameState.getPlayerInActionHoleCards())) {
                                        return gameState.getCurrentBuyIn();
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            
            case "MIDDLE": {
                break;
            }
            
            case "FINAL": {
                break;
            }
        }
        return 0;
    }

    public static void showdown(GameState gameState) {
    }
}
