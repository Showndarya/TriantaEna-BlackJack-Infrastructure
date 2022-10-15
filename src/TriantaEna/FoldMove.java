package TriantaEna;

import Common.Tuple;

public class FoldMove implements GameObjects.Move {
    /*
    * The Fold move class. Implements to Move class from Game Objects.
    */
    @Override
    public Boolean isValidMove(Tuple move, int boardLength, int boardWidth, GameObjects.Board b) {
        return true;
    }

    @Override
    public Boolean isValidMove(Tuple move, GameObjects.Board b) {
        return true;
    }

    @Override
    public Boolean isWinningMove(Tuple move, GameObjects.Board b, int pieceId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void makeMove(Tuple move, GameObjects.Board b) {
        /*
         * If the player is not Bust, then fold.
         */
        Player player = (Player) move.GetFirst();
        Board board = (Board) b;
        if(!player.checkIfBust(board)){
            player.fold(board);
            player.SetFolds();
            player.AddMove(new Tuple(this.getClass().toString(), move));
        }
    }

}
