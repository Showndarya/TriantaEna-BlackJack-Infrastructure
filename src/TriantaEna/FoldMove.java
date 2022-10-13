package TriantaEna;

import Common.Tuple;
import GameObjects.Board;

public class FoldMove implements GameObjects.Move {

    @Override
    public Boolean isValidMove(Tuple move, int boardLength, int boardWidth, Board b) {
        return true;
    }

    @Override
    public Boolean isValidMove(Tuple move, Board b) {
        return true;
    }

    @Override
    public Boolean isWinningMove(Tuple move, Board b, int pieceId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void makeMove(Tuple move, Board b) {
        Player player = (Player) move.GetFirst();
        if(!player.checkIfBust()){
            player.fold();
            player.AddMove(new Tuple(this.getClass().toString(), move));
        }
    }

}
