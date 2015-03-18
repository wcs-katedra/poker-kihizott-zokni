package com.wcs.poker.betting.handUtil;

import com.wcs.poker.model.GameStage;
import com.wcs.poker.model.hands.Hand;

import java.util.Collections;
import java.util.List;

public class Best<T extends List<List<Hand>>> {

    private T hands;
    private GameStage gameStage;

    public Best(T hands, GameStage gameStage) {
        this.hands = hands;
        this.gameStage = gameStage;
    }

    public Hand selectBest() {
        return null;
    }
}
