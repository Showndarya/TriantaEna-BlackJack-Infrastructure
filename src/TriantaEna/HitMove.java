package TriantaEna;

import Common.Tuple;

public class HitMove implements GameObjects.Move{

    public Boolean isValidMove(Tuple move, int boardLength, int boardWidth, GameObjects.Board b) {
        return true;
    }

    public Boolean isValidMove(Tuple move, GameObjects.Board b) {
        return true;
    }

    public Boolean isWinningMove(Tuple move, GameObjects.Board b, int pieceId) {
        return null;
    }

    public void makeMove(Tuple move, GameObjects.Board b) {
        Player player = (Player) move.GetFirst();
        Board board = (Board) b;

        Card card = Deck.PickNextCard();
        int cardNumber = player.countCardsInHand();
        
        board.SetBoardMove(new Tuple(player.GetId(), cardNumber), card);
        player.addCountCardsInHand();
    }

}
