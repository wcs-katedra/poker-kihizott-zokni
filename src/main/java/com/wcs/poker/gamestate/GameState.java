
package com.wcs.poker.gamestate;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GameState {

    @SerializedName("small_blind")
    @Expose
    private Integer smallBlind;
    @SerializedName("current_buy_in")
    @Expose
    private Integer currentBuyIn;
    @Expose
    private Integer pot;
    @SerializedName("minimum_raise")
    @Expose
    private Integer minimumRaise;
    @Expose
    private Integer dealer;
    @Expose
    private Integer orbits;
    @SerializedName("in_action")
    @Expose
    private Integer inAction;
    @Expose
    private List<Player> players = new ArrayList<Player>();
    @SerializedName("community_cards")
    @Expose
    private List<Card> communityCards = new ArrayList<Card>();

    public Integer getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(Integer smallBlind) {
        this.smallBlind = smallBlind;
    }

    public Integer getCurrentBuyIn() {
        return currentBuyIn;
    }

    public void setCurrentBuyIn(Integer currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    public Integer getPot() {
        return pot;
    }

    public void setPot(Integer pot) {
        this.pot = pot;
    }

    public Integer getMinimumRaise() {
        return minimumRaise;
    }

    public void setMinimumRaise(Integer minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

    public Integer getDealer() {
        return dealer;
    }

    public void setDealer(Integer dealer) {
        this.dealer = dealer;
    }

    public Integer getOrbits() {
        return orbits;
    }

    public void setOrbits(Integer orbits) {
        this.orbits = orbits;
    }

    public Integer getInAction() {
        return inAction;
    }

    public void setInAction(Integer inAction) {
        this.inAction = inAction;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }
}
