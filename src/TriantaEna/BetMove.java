package TriantaEna;

import GameObjects.Move;
import Common.Tuple;

public class BetMove implements Move{
	public Boolean isValidMove(Tuple move, GameObjects.Board board) {
        /* 
            Validator for the move
        */
        Player player = (Player) move.GetFirst();
        int bet = (int) move.GetSecond();
        int betLimit = player.getBetLimit();
        if (bet > betLimit) {
            return false;
        }
        return true;
    }

    public void makeMove(Tuple move, GameObjects.Board board) {
        Player player = (Player) move.GetFirst();
        int bet = (int) move.GetSecond();

        int betLimit = player.getBetLimit();
        player.setBetLimit(betLimit - bet);

        player.AddMove(new Tuple(this.getClass().toString(), move));
    }

    public Boolean isWinningMove(Tuple move, GameObjects.Board board, int pieceId) {
        return null;
    }

    public Boolean isValidMove(Tuple move, int boardLength, int boardWidth, GameObjects.Board board) {
        return null;
    }

}
