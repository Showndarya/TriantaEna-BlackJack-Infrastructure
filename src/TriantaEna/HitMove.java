package TriantaEna;

import Common.Tuple;

public class HitMove implements GameObjects.Move{
    /*
     * The Hit move class. Implements to Move class from Game Objects.
     */
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
        /*
         * If the player isnt bust then hit. The player gets a new card from the deck.
         */
        Player player = (Player) move.GetFirst();
        Board board = (Board) b;
        if(!player.checkIfBust(board)){

            Card card = Deck.PickNextCard();
            int cardNumber = player.countCardsInHand();
            
            board.SetBoardMove(new Tuple(player.GetId(), cardNumber), card);
            player.addCountCardsInHand();
            player.setHandValue(card.getRank().GetValue());

            player.AddMove(new Tuple(this.getClass().toString(), move));
            player.SetHits();
        }
    }

}
