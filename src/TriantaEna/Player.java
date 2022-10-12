package TriantaEna;

public class Player extends GameObjects.Player {
    protected int BetLimit;
    protected int CountCardsInHand;
    protected boolean IsBanker;
    protected boolean HasFolded;

    public Player(int id) {
		super(id);
		this.IsBanker=false;
        this.HasFolded=true;
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

    public void fold(){
        this.HasFolded = true;
    }

}
