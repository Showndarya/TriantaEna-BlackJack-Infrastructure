package GameObjects;
import Common.*;

public interface Move {	
	/*
	 * Interface to represent a player’s move. For example placing a piece in tic tac toe, or a castle move in chess.
	 */
	public Boolean isValidMove(Tuple move, int boardLength, int boardWidth, Board b);	
	public Boolean isValidMove(Tuple move, Board b);	
	public Boolean isWinningMove(Tuple move, Board b, int pieceId);		
	public void makeMove(Tuple move, Board b);
}