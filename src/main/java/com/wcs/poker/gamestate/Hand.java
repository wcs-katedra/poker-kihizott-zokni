/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.gamestate;

/**
 *
 * @author Admin
 */
public class Hand {

    private Card Card1;
    private Card Card2;

    public Hand(Card Card1, Card Card2) {
        this.Card1 = Card1;
        this.Card2 = Card2;
    }

    public Card getCard1() {
        return Card1;
    }

    public void setCard1(Card Card1) {
        this.Card1 = Card1;
    }

    public Card getCard2() {
        return Card2;
    }

    public void setCard2(Card Card2) {
        this.Card2 = Card2;
    }
    
    public boolean rankEquals(Hand hand){
        if(Card1.getRank().equals(hand.getCard1().getRank()) && Card2.getRank().equals(hand.getCard2().getRank())){
            return true;
        }
        if(Card1.getRank().equals(hand.getCard2().getRank()) && Card2.getRank().equals(hand.getCard1().getRank())){
            return true;
        }
        return false;
    }
    
}
