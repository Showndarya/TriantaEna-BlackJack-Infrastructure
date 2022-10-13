package TriantaEna;

public class Player extends GameObjects.Player {
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
        this.HandValue = handValue;
    }

    public void printCards(Board board) {
        Card[] cards = board.getPlayerCards(this);

        for(int i = 0; i < cards.length; i++) {
            cards[i].Print();
        }
    }

    public Boolean checkIfBust(Board b) {
        if (!this.IsBust && this.HandValue >= 31) {
            this.bust(b);
        }
        return this.IsBust;
    }
}
