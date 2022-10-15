package GameObjects;

import java.util.ArrayList;

public abstract class Engine {
	/*
	 * Abstract class which houses the main game loop. Used to create the game board,
	 * add players, teams, while keeping track of the overall scores.
	 */
	protected Board Board;	
	protected ArrayList<Team> Teams;	
	protected ArrayList<Player> Players;	
	protected Score Stats;
	
	public Board GetBoard() {
		return this.Board;
	}
	
	public void AddTeam(int id, String name, Piece piece, ArrayList<Player> players) {
		Team team = new Team(id);
		team.SetName(name);
		team.SetPiece(piece);
		team.AddPlayerRange(players);
		this.Teams.add(team);	
	}
	
	public ArrayList<Team> GetTeams() {
		return this.Teams;
	}
	
	public ArrayList<Player> GetPlayers() {
		return this.Players;
	}
	
	public abstract void AddPlayer(int id, String name, int balance);
}
