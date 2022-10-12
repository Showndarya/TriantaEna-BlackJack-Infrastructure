package TriantaEna;

import Common.IOWrapper;
import Common.Tuple;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOWrapper io = new IOWrapper();
		Engine e = new Engine();
		int n=io.GetUserInputTypeInt("Enter number of players in the game(7-9):");
		for(int i=0;i<n;i++) {
			String name=io.GetUserInputTypeString(String.format("Enter player %s name: ", i+1));
			e.AddPlayer(i, name, 100);
		}
		
		Player banker=(Player) e.GetPlayers().get(0);
		banker.SetBanker();
		e.InitBoard(12, 0, n);
		
		
		IOWrapper.SysOutNL("Starting round..");
		IOWrapper.SysOutNL("First card...");
		for(int i=0;i<n;i++) {
			IOWrapper.SysOutNL(String.format("For player %s", i+1));
			Card card=Deck.PickNextCard();
			Player player=(Player) e.GetPlayers().get(i);
			Board board=(Board) e.GetBoard();
			Tuple move=new Tuple(i,card);
			board.SetBoardMove(move, i);
			player.addCountCardsInHand();
			card.Print();
		}
	}

}
