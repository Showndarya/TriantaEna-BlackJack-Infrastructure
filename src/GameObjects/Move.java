package GameObjects;
import Common.*;

public interface Move {	
	public Boolean isValidMove(Tuple move, int boardLength, int boardWidth, Board b);	
	public Boolean isValidMove(Tuple move, Board b);	
	public Boolean isWinningMove(Tuple move, Board b, int pieceId);		
	public void makeMove(Tuple move, Board b);
}