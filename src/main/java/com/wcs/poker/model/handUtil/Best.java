package com.wcs.poker.model.handUtil;

import com.wcs.poker.model.hands.Hand;

import java.util.Collections;
import java.util.List;

public class Best<T extends List<Hand>> {

    private T hands;

    public Best(T hands) {
        this.hands = hands;
    }

    public Hand selectBest() {
        Collections.sort(hands);
        return hands.get(0);
    }
}
