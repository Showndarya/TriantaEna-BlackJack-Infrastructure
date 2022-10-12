package TriantaEna;

public class Player extends GameObjects.Player {
    protected int BetLimit;
    protected int CountCardsInHand;

    public Player(int id) {
		super(id);
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

    public void setCountCardsInHand(int countCardsInHand) {
        this.CountCardsInHand = countCardsInHand;
    }

}
