package TriantaEna;

import java.util.ArrayList;
import Common.Tuple;
import GameObjects.Piece;

public class Board extends GameObjects.Board {
	
	public Board(int width, int height, int nextPlayer, int totalPlayersCount) {
		super(width, height, nextPlayer,totalPlayersCount);		
	}

	@Override
	public void PrintBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SetBoardMove(Tuple position, Object m) {
		Card card = (Card) m;
		int playerId = (int) position.GetFirst();
		int cardNumber = (int) position.GetSecond();

		Cell cell = (Cell) BoardLayout[playerId][cardNumber];
		cell.SetValue(card);
	}

	@Override
	public int GetBoardMove(Tuple position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Piece> GetBoardPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean IsValidPiece(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetBoardSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int GetBoardSizePerPlayer(int playerId) {
		// TODO Auto-generated method stub
		return this.BoardLayout[playerId].length;
	}
	
}; 