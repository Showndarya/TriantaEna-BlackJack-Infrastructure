package TriantaEna;

import GameObjects.Card;

public class Cell extends GameObjects.Cell {
    protected Card Value;
	
	protected int WinWhenStarted;
	
	public Cell() {
		this.WinWhenStarted = 0;
	}
	
	public Card GetValue() {
		return this.Value;
	}
	
	public void SetValue(Card value) {
		this.Value = value;
	}

}