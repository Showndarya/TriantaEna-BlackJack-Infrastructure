package TriantaEna;

public class Score extends GameObjects.Score {

	private int currentBet;
	public Score(int wins, int draws, int total) {
		super(wins, draws, total);
		this.currentBet=0;
		// TODO Auto-generated constructor stub
	}
	
	public void SetCurrentBet(int currentBet) {
		this.currentBet=currentBet;
	}
	
	public int GetCurrentBet() {
		return this.currentBet;
	}

}
