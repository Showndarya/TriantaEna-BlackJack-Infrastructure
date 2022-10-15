package GameObjects;

import java.util.ArrayList;

import Common.*;

public interface Turn {	
	// Interface to hold functions for handling turn based games.
	
	public void PromptTurn(ArrayList<Team> teams, Board b);	
	public Tuple UpdateBoard(String[] userInputSplit, Team currentTeam, Board b);
	public Boolean DecideGameEnd(Move move, Tuple position, Team currentTeam, Board b,ArrayList<Team> teams);
}
