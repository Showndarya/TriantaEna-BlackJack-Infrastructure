package TriantaEna;


public class Score extends GameObjects.Score {

	private int currentBet;
	private int Hits;
    private int Busts;
    private int Folds;
    private int Stands;
	

	public Score(int wins, int draws, int total) {
		super(wins, draws, total);
		this.currentBet=0;
		this.Busts=0;
		this.Hits=0;
		this.Stands=0;
		this.Folds=0;
		// TODO Auto-generated constructor stub
	}
	
	public void SetCurrentBet(int currentBet) {
		this.currentBet=currentBet;
	}
	
	public int GetCurrentBet() {
		return this.currentBet;
	}
	
	public void addHit() {
	    this.Hits++;
	}
    
    public void addBust() {
        this.Busts++;
    }
    
    public void addStand() {
        this.Stands++;
    }
    
    public void addFold() {
        this.Folds++;
    }
    
    public int getHits() {
        return this.Hits++;
    }
    
    public int getBusts() {
        return this.Busts++;
    }
    
    public int getStands() {
        return this.Stands++;
    }
    
    public int getFolds() {
        return this.Folds++;
    }
    
    public String DisplayStats() {
        return "Hits: "+this.Hits+";Folds: "+this.Folds+"; Busts: "+this.Busts+"; Stands: "+this.Stands;
    }
}
