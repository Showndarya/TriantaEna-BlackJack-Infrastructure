package TriantaEna;

import Common.Tuple;

public class StandMove implements GameObjects.Move {

    @Override
    public Boolean isValidMove(Tuple move, int boardLength, int boardWidth, GameObjects.Board b) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean isValidMove(Tuple move, GameObjects.Board b) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean isWinningMove(Tuple move, GameObjects.Board b, int pieceId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void makeMove(Tuple move, GameObjects.Board b) {
        Player player = (Player) move.GetFirst();
        Board board = (Board) b;
        if(!player.checkIfBust(board)){
            player.fold(board);
            player.AddMove(new Tuple(this.getClass().toString(), move));
        }
    }

}
