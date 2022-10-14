package TriantaEna;

import java.util.ArrayList;
import Common.Tuple;
import GameObjects.Piece;

public class Board extends GameObjects.Board {
	private int CountBustedPlayers;
	private int CountFoldedPlayers;

	public Board(int nextPlayer, int totalPlayersCount, int maxCardsPerPlayer) {
		super(totalPlayersCount, maxCardsPerPlayer, nextPlayer,totalPlayersCount);	
		this.CountBustedPlayers = 0;	
	}

	@Override
	public void PrintBoard() {
		for (int playerId = 0; playerId < this.Width; playerId++) {
			for (int cellId = 0; cellId < this.Height; cellId++) {
				Cell cell = (Cell) this.BoardLayout[playerId][cellId];
				cell.printCell();
			}
		}
	}

	@Override
	public void SetBoardMove(Tuple position, Object m) {
		Card card = (Card) m;
		int playerId = (int) position.GetFirst();
		int cardNumber = (int) position.GetSecond();

		if((Cell) BoardLayout[playerId][cardNumber] == null) {
			BoardLayout[playerId][cardNumber]=new Cell();
		} 
		BoardLayout[playerId][cardNumber].SetValue(card);
	}

	@Override
	public Object GetBoardMove(Tuple position) {
		int playerId = (int) position.GetFirst();
		int cardNumber = (int) position.GetSecond();
		Cell cell = (Cell) BoardLayout[playerId][cardNumber];
		return cell.GetValue();
	}

	@Override
	public ArrayList<Piece> GetBoardPieces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean IsValidPiece(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetBoardSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int GetBoardSizePerPlayer(int playerId) {
		return this.BoardLayout[playerId].length;
	}

	public int calculatePlayerScore(Player player) {
		int playerId = player.GetId();
		int cardNumber = player.countCardsInHand();
		int score = 0;
		for (int i = 0; i < cardNumber; i++) {
			Cell cell = (Cell) this.BoardLayout[playerId][i];
			Card card = cell.GetValue();
			score += card.getRank().GetValue();
		}

		return score;
	}

	public Card[] getPlayerCards(Player player){
		int playerId = player.GetId();
		int totalCards = player.countCardsInHand();

		Card[] cards = new Card[totalCards];
		for (int i = 0; i < totalCards && i < this.Height; i++) {
			Cell cell = (Cell) this.BoardLayout[playerId][i];
			cards[i] = cell.GetValue();
		}
		return cards;
	}
	
	public void incrementBustedPlayers() {
		this.CountBustedPlayers += 1;
	}

	public void incrementFoldedPlayers() {
		this.CountFoldedPlayers += 1;
	}

	public int countBustedPlayers() {
		return this.CountBustedPlayers;
	}

	public int countFoldedPlayers() {
		return this.CountFoldedPlayers;
	}

	public Boolean arePlayersDown() {
		return this.Width - 1 == this.CountBustedPlayers + this.CountFoldedPlayers;
	}
}; 