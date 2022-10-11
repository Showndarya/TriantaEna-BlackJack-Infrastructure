package TriantaEna;

import java.util.HashMap;
import java.util.ArrayList;

import Common.Tuple;

public class Board extends GameObjects.Board {
	protected HashMap<int><ArrayList> BoardLayout;	

	public Board(int width, int height, int nextPlayer, int totalPlayersCount) {
		this.BoardLayout = new HashMap<int><ArrayList>;
		this.Width = width;
		this.Height = height;
		Init(nextPlayer, totalPlayersCount);
	}

	public Board(int boardSize, int nextPlayer, int totalPlayersCount) {
		this(boardSize, boardSize, nextPlayer, totalPlayersCount);
	}

    public Tuple GetBoardSize() {
        return new Tuple(this.Width, this.Height);
    }
}; 