package TriantaEna;

import java.util.ArrayList;

import GameObjects.Piece;
import GameObjects.Team;
import GameObjects.Score;

public class Engine extends GameObjects.Engine {

	public Engine() {
		Players = new ArrayList<GameObjects.Player>();
		Stats = new Score(0,0,0);
	}
	
	public void InitBoard(int nextPlayer, int totalPlayers, int maxCardsPerPlayer) {
		Board = new Board(nextPlayer, totalPlayers, maxCardsPerPlayer);
		Deck.InitCards();
		Deck.ShuffleCards();
	}
	
	public void SetTeamPiece(int id, Piece piece) {
		for(Team team: Teams) {
			if(team.GetId() == id) team.SetPiece(piece);
		}
	}
	
	public void AddPlayer(int id, String name, int balance) {
		Player player = new Player(id);
		player.SetName(name);
		player.setBetLimit(balance);
		this.Players.add(player);	
	}
}
