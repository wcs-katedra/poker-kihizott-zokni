package com.wcs.poker.gamestate;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class GameState {

    private final String dealerPosition = "BU";
    private final String smallBlindPosition = "SB";
    private final String bigBlindPosition = "BB";
    private final String middlePosition = "MP";
    private final String cutoffPosition = "CO";
    private final String cleanPot = "CLN";
    private final String limpedPot = "LMPD";
    private final String raisedPot = "RSD";
    private final String earlyRacePhase = "EARLY";
    private final String middleRacePhase = "MIDDLE";
    private final String finalRacePhase = "FINAL";

    private String position;

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

    /**
     *
     * @return The smallBlind
     */
    public Integer getSmallBlind() {
        return smallBlind;
    }

    /**
     *
     * @param smallBlind The small_blind
     */
    public void setSmallBlind(Integer smallBlind) {
        this.smallBlind = smallBlind;
    }

    /**
     *
     * @return The currentBuyIn
     */
    public Integer getCurrentBuyIn() {
        return currentBuyIn;
    }

    /**
     *
     * @param currentBuyIn The current_buy_in
     */
    public void setCurrentBuyIn(Integer currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    /**
     *
     * @return The pot
     */
    public Integer getPot() {
        return pot;
    }

    /**
     *
     * @param pot The pot
     */
    public void setPot(Integer pot) {
        this.pot = pot;
    }

    /**
     *
     * @return The minimumRaise
     */
    public Integer getMinimumRaise() {
        return minimumRaise;
    }

    /**
     *
     * @param minimumRaise The minimum_raise
     */
    public void setMinimumRaise(Integer minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

    /**
     *
     * @return The dealer
     */
    public Integer getDealer() {
        return dealer;
    }

    /**
     *
     * @param dealer The dealer
     */
    public void setDealer(Integer dealer) {
        this.dealer = dealer;
    }

    /**
     *
     * @return The orbits
     */
    public Integer getOrbits() {
        return orbits;
    }

    /**
     *
     * @param orbits The orbits
     */
    public void setOrbits(Integer orbits) {
        this.orbits = orbits;
    }

    /**
     *
     * @return The inAction
     */
    public Integer getInAction() {
        return inAction;
    }

    /**
     *
     * @param inAction The in_action
     */
    public void setInAction(Integer inAction) {
        this.inAction = inAction;
    }

    /**
     *
     * @return The players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @param players The players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     *
     * @return The communityCards
     */
    public List<Card> getCommunityCards() {
        return communityCards;
    }

    /**
     *
     * @param communityCards The community_cards
     */
    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }

    public int getCallValue() {
        return currentBuyIn - players.get(inAction).getBet();
    }

    public Player getActualPlayer() {
        return players.get(inAction);
    }

    public int getBigBlind() {
        return 2 * smallBlind;
    }

    public int getStackSizeInBBs() {
        return players.get(inAction).getStack() / getBigBlind();
    }

    public String getPotStatus() {
        if (currentBuyIn > getBigBlind()) {
            return raisedPot;
        }
        if (pot == 3 * smallBlind) {
            return cleanPot;
        }
        return limpedPot;
    }

    public int getNumberOfPosition() {
        return Math.abs(dealer - inAction);
    }

    private void evaluatePosition() {
        switch (players.size()) {
            case 4: {
                switch (getNumberOfPosition()) {
                    case 0: {
                        position = dealerPosition;
                        break;
                    }
                    case 1: {
                        position = smallBlindPosition;
                        break;
                    }
                    case 2: {
                        position = bigBlindPosition;
                        break;
                    }
                    case 3: {
                        position = cutoffPosition;
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (getNumberOfPosition()) {
                    case 0: {
                        position = bigBlindPosition;
                        break;
                    }
                    case 1: {
                        position = smallBlindPosition;
                        break;
                    }
                }
                break;
            }
            default: {
                switch (getNumberOfPosition()) {
                    case 0: {
                        position = dealerPosition;
                        break;
                    }
                    case 1: {
                        position = smallBlindPosition;
                        break;
                    }
                    case 2: {
                        position = bigBlindPosition;
                        break;
                    }
                    case 3: {
                        position = middlePosition;
                        break;
                    }
                    case 4: {
                        position = cutoffPosition;
                        break;
                    }
                }
                break;
            }
        }
    }

    public String evaluateRacePhase() {
        if (getStackSizeInBBs() > 24) {
            return earlyRacePhase;
        }
        if (getStackSizeInBBs() > 13 && getStackSizeInBBs() <= 24) {
            return middleRacePhase;
        }
        return finalRacePhase;
    }

    public String getPosition() {
        evaluatePosition();
        return position;
    }

}
