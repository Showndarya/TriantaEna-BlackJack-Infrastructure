package GameObjects;
import Common.*;

import java.util.ArrayList;

public abstract class Board {	
	/*
	 Elements of the board like board dimensions, board layout, count of players, game pieces.
	 Functions to set board pieces, game moves, resetting the board, printing the board on the terminal.
	 */
	protected void Init(int nextPlayer, int totalPlayersCount) {
		this.NextPlayer = nextPlayer;
		this.Pieces = new ArrayList<Piece>();
		this.TotalPlayersCount = totalPlayersCount;
		this.FilledBoardPositionsCount = 0;
	}
	
	protected ArrayList<Piece> Pieces;	
	protected int NextPlayer;	
	protected Cell[][] BoardLayout;	
	protected int Width;		
	protected int Height;	
	protected int TotalPlayersCount;	
	protected int FilledBoardPositionsCount;
	
	public Board(int width, int height, int nextPlayer, int totalPlayersCount) {
		this.BoardLayout = new Cell[width][height];
		this.Width = width;
		this.Height = height;
		Init(nextPlayer, totalPlayersCount);
	}
	
	public Board(int boardSize, int nextPlayer, int totalPlayersCount) {
		this.BoardLayout = new Cell[boardSize][boardSize];
		this.Width = boardSize;
		this.Height = boardSize;
		Init(nextPlayer, totalPlayersCount);
	}

	public int GetNextPlayer() {
		return this.NextPlayer;
	}
	
	public int GetTotalPlayersCount() {
		return this.TotalPlayersCount;
	}
	
	public int GetFilledBoardPositionsCount() {
		return this.FilledBoardPositionsCount;
	}	

	public void SetFilledBoardPositionsCount() {
		this.FilledBoardPositionsCount++;
	}	
	
	public void ResetFilledBoardPositionsCount() {
		this.FilledBoardPositionsCount = 0;
	}	

	public void SetNextPlayer(int id) {
		this.NextPlayer = id;
	}	

	public Cell[][] GetBoard() {
		return this.BoardLayout;
	}
	
	public abstract int GetBoardSize();
	
	public abstract int GetBoardSizePerPlayer(int playerId);
	 
	public abstract void PrintBoard();
	
	public abstract void SetBoardMove(Tuple position, Object m);
	
	public abstract Object GetBoardMove(Tuple position);
	
	public abstract ArrayList<Piece> GetBoardPieces();
	
	public abstract Boolean IsValidPiece(String key);

	public Board SetBoardPieces(Piece piece) {
		this.Pieces.add(piece);
		return this;
	}
}
