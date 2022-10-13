package TriantaEna;

import java.util.Random;

import Common.IOWrapper;
import Common.Tuple;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOWrapper io = new IOWrapper();
		Random rand = new Random();
		Engine e = new Engine();
		int n=io.GetUserInputTypeInt("Enter number of players in the game(7-9):");
		for(int i=0;i<n;i++) {
			String name=io.GetUserInputTypeString(String.format("Enter player %s name: ", i+1));
			e.AddPlayer(i, name, 100);
		}
		

	    int bankerId=rand.nextInt(n);
		Player banker=(Player) e.GetPlayers().get(bankerId);
		banker.SetBanker();
		
		e.InitBoard(0, n, 12);
        Board board=(Board) e.GetBoard();
		IOWrapper.SysOutNL("Starting round..");
		IOWrapper.SysOutNL("First card...");
		for(int i=0;i<n;i++) {
			IOWrapper.SysOutNL(String.format("For player %s", i+1));
			Card card=Deck.PickNextCard();
			Player player=(Player) e.GetPlayers().get(i);
			Tuple move=new Tuple(i,player.countCardsInHand());
			board.SetBoardMove(move, card);
			player.addCountCardsInHand();
			card.Print();
		}
		
		for(int i=0;i<n;i++) {
            Player player=(Player) e.GetPlayers().get(i);
            if(player.IsBanker()) continue;
			IOWrapper.SysOutNL(String.format("Player %s", i+1));
			int selection=io.GetUserInputTypeInt("1 for Bet or 2 for Fold:");
			GameObjects.Move move;
			switch(selection) {
			case 1:
				int betAmount=io.GetUserInputTypeInt("Enter your bet:");
				move=new BetMove();
				move.makeMove(new Tuple(player, betAmount), board);
				break;
			case 2:
				move=new FoldMove();
				move.makeMove(new Tuple(player, i), board);
				break;
				
			}
		}
		do {
    		for(int i=0;i<n;i++) {
    			Player player=(Player) e.GetPlayers().get(i);
    			if(player.HasFolded() || player.IsBust() || player.IsBanker()) {
    			    continue;
    			}			
    
                IOWrapper.SysOutNL(String.format("Player %s", i+1));
                int selection=io.GetUserInputTypeInt("1 for Hit or 2 for Stand:");
                GameObjects.Move move;
                switch(selection) {
                    case 1:
                        move=new HitMove();
                        move.makeMove(new Tuple((Player) e.GetPlayers().get(i), i ), board);
                        break;
                    case 2:
                        move=new StandMove();
                        move.makeMove(new Tuple((Player) e.GetPlayers().get(i), i ), board);
                        break;
                        
                    }
    		}
		} while(!board.arePlayersDown());
		
		do {
		    IOWrapper.SysOutNL("For banker..");
            Card card=Deck.PickNextCard();
            Tuple move=new Tuple(bankerId,banker.countCardsInHand());
            board.SetBoardMove(move, card);
            banker.addCountCardsInHand();
            card.Print();
		} while(banker.getHandValue()<=27);
	}

}
