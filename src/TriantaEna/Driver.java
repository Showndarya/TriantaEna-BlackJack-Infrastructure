package TriantaEna;

import java.util.Random;

import Common.IOWrapper;
import Common.Tuple;

public class Driver {
      /* 
       Class to handle the gameplay for TriantaEna
     */
    int n;
    IOWrapper io = new IOWrapper();
    Random rand = new Random();
    Engine e = new Engine();
    Board board;
    Player banker;
    int bankerId;
    
    public void open() {
        /* 
        Prompts the player to get the player count
      */
        PromptPlayerCount();
        /* 
        Prompts the player to get the player information
      */
        GetPlayerInformation();
        /* 
        Choose the banker of the round from the players
      */
        ChooseBanker();
        /* 
        Initialize the board for the game
      */
        InitBoard();
        /* 
        First card is given out to each player
      */
        StartRound();
        /* 
        Prompts each player to choose to bet or fold
      */
        HandlePlayerBetOrFold();
        /* 
        Prompts each player to hit or stand till all players go bust
      */
        HandlePlayerGamePlay();
        /* 
        Generates cards for the banker till the hand value exceeds 27
      */
        HandleBankerGamePlay();
        /* 
        Display player specific moves history/statistics
      */
        DisplayPlayerSpecificScores();
        /* 
        Decide winner(s) of the game
      */
        CalculateWinning();
    }
    
    private void PromptPlayerCount() {
        n=io.GetUserInputTypeInt("Enter number of players in the game(7-9):");
    }
    
    private void GetPlayerInformation() {
        for(int i=0;i<n;i++) {
            String name=io.GetUserInputTypeString(String.format("Enter player %s name: ", i+1));
            e.AddPlayer(i, name, 100);
        }        
    }
    
    private void ChooseBanker() {
        bankerId=rand.nextInt(n);
        banker=(Player) e.GetPlayers().get(bankerId);
        banker.SetBanker();
        IOWrapper.SysOutNL(String.format("Banker for the round: %s", banker.GetName()));
    }
    
    private void InitBoard() {
        e.InitBoard(0, n, 12);
        board=(Board) e.GetBoard();
    }
    
    private void StartRound() {        
        IOWrapper.SysOutNL("Starting round..");
        IOWrapper.SysOutNL("First card...");
        for(int i=0;i<n;i++) {
            IOWrapper.SysOutNL(String.format("For player %s", i+1));
            Card card=Deck.PickNextCard();
            Player player=(Player) e.GetPlayers().get(i);
            player.setHandValue(card.getRank().GetValue());
            Tuple move=new Tuple(i,player.countCardsInHand());
            board.SetBoardMove(move, card);
            player.addCountCardsInHand();
            card.Print();
        }
    }
    
    private void HandlePlayerBetOrFold() {        
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
    }
    
    private void HandlePlayerGamePlay() {
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
                if(player.getHandValue()>31) {
                    player.bust(board);
                    player.SetBusts();
                }
            }
        } while(!board.arePlayersDown());
    }
    
    private void HandleBankerGamePlay() {        
        do {
            IOWrapper.SysOutNL("For banker..");
            Card card=Deck.PickNextCard();
            banker.setHandValue(card.getRank().GetValue());
            Tuple move=new Tuple(bankerId,banker.countCardsInHand());
            board.SetBoardMove(move, card);
            banker.addCountCardsInHand();
            card.Print();
        } while(banker.getHandValue()<=27);       

        DecideBankerBust();
    }
    
    private void DecideBankerBust() {
        if(banker.getHandValue()>31) {
            banker.bust(board);
            banker.SetBusts();
        }
    }
    
    private void DisplayPlayerSpecificScores() {
        for(int i=0;i<n;i++) {
            Player player=(Player) e.GetPlayers().get(i);
            IOWrapper.SysOutNL(String.format("Player %s: %s",
                    i+1, player.getHandValue()));
            IOWrapper.SysOutNL(player.DisplayStats());
            
        }
    }
    
    private void CalculateWinning() {
        if(banker.IsBust()) {
            for(int i=0;i<n;i++) {
                Player player=(Player) e.GetPlayers().get(i);
                if(!player.IsBust()) IOWrapper.SysOutNL(String.format("Player %s wins", i+1));
                else IOWrapper.SysOutNL(String.format("Player %s lost", i+1));
            }
        } else {
            for(int i=0;i<n;i++) {
                Player player=(Player) e.GetPlayers().get(i);
                if(!player.IsBust()) {
                    if(player.getHandValue() > banker.getHandValue()) IOWrapper.SysOutNL(String.format("Player %s wins", i+1));
                    else IOWrapper.SysOutNL(String.format("Banker wins"));
                }
                else IOWrapper.SysOutNL(String.format("Player %s lost", i+1));
            }
        }
    }
}
