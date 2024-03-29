package TriantaEna;

import Common.Constants;

public class Player extends GameObjects.Player {
    /*
     * Extends the Player class while adding additional private variables.
     * IsBanker represents if the player is the dealer.
     * IsFolded, IsStanded, IsBust represents if the player folds, stands, or is bust.
     * Stores the current hand value and the number of cards in hand
     */
    private int BetLimit;
    private int CountCardsInHand;
    private boolean IsBanker;
    private boolean HasFolded;
    private boolean HasStanded;
    private boolean IsBust;
    private int HandValue;

    public Player(int id) {
		super(id);
		this.IsBanker=false;
        this.HasFolded=false;
        this.HasStanded=false;
        this.IsBust=false;
        this.HandValue = 0;
        this.CountCardsInHand=0;
	}

    public void setBetLimit(int betLimit) {
        this.BetLimit = betLimit;
    }

    public int getBetLimit() {
        return this.BetLimit;
    }

    public void decrementBetLimit(int value) {
        this.BetLimit -= value;
    }

    public int countCardsInHand() {
        return this.CountCardsInHand;
    }

    public void addCountCardsInHand() {
        this.CountCardsInHand++;
    }
    
    public void SetBanker() {
    	this.IsBanker=true;
    }
    
    public Boolean IsBanker() {
    	return this.IsBanker;
    }

    public Boolean HasFolded() {
        return this.HasFolded;
    }
    
    public Boolean HasStanded() {
        return this.HasStanded;
    }
    
    public Boolean IsBust() {
        return this.IsBust;
    }
    
    public void SetBusts() {
        var stats=(Score) this.GetStats();
        stats.addBust();
        this.SetStats(stats);
    }

    public void SetHits() {
        var stats=(Score) this.GetStats();
        stats.addHit();
        this.SetStats(stats);
    }

    public void SetStands() {
        var stats=(Score) this.GetStats();
        stats.addStand();
        this.SetStats(stats);
    }

    public void SetFolds() {
        var stats=(Score) this.GetStats();
        stats.addFold();
        this.SetStats(stats);
    }

    public void fold(Board b) {
        if(!this.HasFolded){
            this.HasFolded = true;
            b.incrementFoldedPlayers();
        }
    }
    
    public void stand() {
        this.HasStanded = true;
    }
    
    public void bust(Board b) {
        if(!IsBust){
            this.IsBust = true;
            b.incrementBustedPlayers();
            
        }
    }

    public int getHandValue() {
        return this.HandValue;
    }

    public void setHandValue(int handValue){
        this.HandValue+= handValue;
    }
    
    public String DisplayStats() {
        var stats=(Score) this.GetStats();
        return stats.DisplayStats();
    }

    public void printCards(Board board) {
        Card[] cards = board.getPlayerCards(this);

        for(int i = 0; i < cards.length; i++) {
            cards[i].Print();
        }
    }

    public Boolean checkIfBust(Board b) {
        if (!this.IsBust && this.HandValue >= Constants.MaximumHandLimit) {
            this.bust(b);
        }
        return this.IsBust;
    }
}
