package TriantaEna;

public class Player extends GameObjects.Player {
    protected int BetLimit;
    protected int CountCardsInHand;
    protected boolean IsBanker;
    protected boolean HasFolded;
    protected boolean HasStanded;
    protected boolean IsBust;
    protected int HandValue;

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

    public void fold() {
        this.HasFolded = true;
    }
    
    public void stand() {
        this.HasStanded = true;
    }
    
    public void bust() {
        this.IsBust = true;
    }

    public int getHandValue() {
        return this.HandValue;
    }

    public void setHandValue(int handValue){
        this.HandValue = handValue;
    }

    public void printCards(Board board) {
        Card[] cards = board.getPlayerCards(this);

        for(int i = 0; i < cards.length; i++) {
            cards[i].Print();
        }
    }

    public Boolean checkIfBust() {
        if (this.HandValue >= 31) {
            this.bust();
        }
        return this.IsBust;
    }
}
