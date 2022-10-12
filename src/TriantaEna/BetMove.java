package TriantaEna;

import GameObjects.Move;
import Common.Tuple;

public class BetMove implements Move{
	public Boolean IsValidMove(Tuple move, Board b) {
        Player player = (Player) move.GetFirst();
        int bet = (int) move.GetSecond();

        int betLimit = player.getBetLimit();

        if (bet > betLimit) {
            return false;
        }
        return true;
    }
}
