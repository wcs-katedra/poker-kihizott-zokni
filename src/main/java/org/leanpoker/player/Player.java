package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.List;

public class Player {

    static final String VERSION = "Default Java folding player";

    //több mint 24 nagyvakunk van, belső pozícióban vagyunk és még senki sem emelt, ezekkel fogunk emelni
    private List<Card> earlyRaiseFromMiddleCards;
    //több mint 24 nagyvakunk van, belső pozícióban vagyunk és még senki sem emelt, ezekkel fogunk limpelni (megadjuk a nagyvak tétet)
    private List<Card> earlyLimpFromMiddleCards;
    
    //több mint 24 nagyvakunk van, hátsó pozícióban vagyunk (CO BU SB BB) és még senki sem emelt, ezekkel fogunk emelni
    private List<Card> earlyRaiseFromBackOrBlindsCards;
    //több mint 24 nagyvakunk van hátsó pozícióban vagyunk (CO BU SB SB) és még senki sem emelt, ezekkel fogunk limpelni
    private List<Card> earlyLimpFromBackOrBlindsCards;
    //több mint 24 nagyvakunk van hátsó pozícióban vagyunk és emelés történt ezekkel a fogjuk callazni az emelést
    private List<Card> earlyCallFromBackOrBlindsCards;
    //több mint 24 nagyvakunk van hátsó pozícióban vagyunk és emelés történt ezekkel a lapokkal visszaemelünk
    
    private List<Card> earlyreraiseFromBackOrBlindsCards;
    //13-23 nagyvakunk van és nem emelt senki ezekkel a lapokkal emelünk
    private List<Card> midRaiseCards;
    //13-23 nagyvakunk van és emeltek elöttünk - a következő lapokkal all-in megyünk
    
    private List<Card> midReRaiseCards;
    //13> nagyvakunk van és nem emelt senki - a következő lapokkal all-in
    private List<Card> finalPushAtLimpedPotCards;
    //13> nagyvakunk van és emeltek elöttünk - a következő lapokkal all-in
    private List<Card> finalPushAtRaisedPotCards;

    public static int betRequest(GameState gameState) {
        switch (gameState.evaluateRacePhase()) {
            case "EARLY": {
                switch (gameState.getPosition()) {
                    case "MP":{
    
                        break;
                    }
                    default:{
                        
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
