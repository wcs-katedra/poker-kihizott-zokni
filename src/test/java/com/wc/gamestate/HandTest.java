/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wc.gamestate;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.Hand;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class HandTest {

    private Hand hand1;
    private Hand hand2;
    private Hand hand3;
    private Hand hand4;

    public HandTest() {
        Card card1 = new Card("A", "spades");
        Card card2 = new Card("K", "diamonds");
        Card card3 = new Card("J", "diamonds");

        hand1 = new Hand(card1, card2);
        hand2 = new Hand(card2, card1);
        hand3 = new Hand(card1, card2);
        hand4 = new Hand(card1, card3);
    }

    @Test
    public void testRankEqualsMethod() {
        assertTrue(hand1.rankEquals(hand2));
        assertTrue(hand1.rankEquals(hand3));
        assertTrue(hand2.rankEquals(hand3));
        
        assertFalse(hand1.rankEquals(hand4));
        assertFalse(hand2.rankEquals(hand4));
    }
}
