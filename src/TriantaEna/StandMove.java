package TriantaEna;

import Common.Tuple;
import GameObjects.Board;

public class StandMove implements GameObjects.Move {

    @Override
    public Boolean isValidMove(Tuple move, int boardLength, int boardWidth, Board b) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean isValidMove(Tuple move, Board b) {
        // TODO Auto-generated method stub
        return null;
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
