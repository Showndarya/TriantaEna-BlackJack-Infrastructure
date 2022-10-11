package TriantaEna;

import GameObjects.Move;
import Common.Tuple;

public class BetMove implements Move{
    public Boolean IsValidMove(String move, int boardLength, int boardWidth, Board b) {

    }

	public Boolean IsValidMove(String move, Board b) {
        Tuple boardSize = b.GetBoardSize();
        int width = b.key;
        int length = b.value;
        this.IsValidMove(move, length, width, b);
    }

	public Boolean IsWinningMove(Tuple move, Board b, int pieceId) {

    }	
}
