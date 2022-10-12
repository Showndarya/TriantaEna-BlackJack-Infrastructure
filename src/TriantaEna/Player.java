package TriantaEna;

public class Player extends GameObjects.Player {
    protected int BetLimit;
    protected int CountCardsInHand;
    protected boolean IsBanker;

    public Player(int id) {
		super(id);
		this.IsBanker=false;
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

}
