package TriantaEna;

public class Player extends GameObjects.Player {
    protected int BetLimit;
    protected int CountCardsInHand;
    protected boolean IsBanker;
    protected boolean HasFolded;
    protected int HandValue;

    public Player(int id) {
		super(id);
		this.IsBanker=false;
        this.HasFolded=true;
        this.HandValue = 0;
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

}
