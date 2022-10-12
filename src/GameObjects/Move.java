package GameObjects;
import Common.*;

public interface Move {	
	public Boolean IsValidMove(Tuple move, int boardLength, int boardWidth, Board b);	
	public Boolean IsValidMove(Tuple move, Board b);	
	public Boolean IsWinningMove(Tuple move, Board b, int pieceId);		
	public void MakeMove(Tuple move, Board b);
}