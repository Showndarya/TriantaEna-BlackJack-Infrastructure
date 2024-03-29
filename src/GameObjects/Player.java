package GameObjects;
import java.util.*;
import Common.*;
import TriantaEna.Score;

public class Player {	
	/*
	 * Houses player information with private variables like name, id, score, past moves.
	 */
	private int Id;	
	private String Name;	
	private Piece Piece;	
	private Score Stats;	
	private ArrayList<Tuple> MovesMade;
	
	public Player(int id) {
		this.Id = id;
		this.MovesMade = new ArrayList<Tuple>();
		this.Stats = new Score(0,0,0);
	}
	
	public String GetName() {
		return this.Name;
	}
	
	public int GetId() {
		return this.Id;
	}
	
	public Piece GetPiece() {
		return this.Piece;
	}
	
	public Score GetStats() {
		return this.Stats;
	}
	
	public void SetWin() {
		this.Stats.SetPlayerWin();
	}

	public void SetTie() {
		this.Stats.SetPlayerDraw();
	}

	public void SetTotal() {
		this.Stats.SetPlayerTotal();
	}
    
    public void SetStats(Score stats) {
        this.Stats=stats;
    }
	
	public void SetPiece(Piece piece) {
		this.Piece = piece;
	}

	public void SetName(String name) {
		this.Name = name;
	}
	public void AddMove(Tuple piece) {
		MovesMade.add(piece);
	}
}
