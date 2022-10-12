package TriantaEna;

import Common.IOWrapper;
import Common.Tuple;
import GameObjects.Piece;
import TriantaEna.Enums.Rank;
import TriantaEna.Enums.Suit;

public class Card extends Piece {	
	private Rank rank;
	
	private Suit suit;
	
	public Card(int key, Rank rank, Suit suit) {
		this.Key=key;
		this.rank=rank;
		this.suit=suit;
	}
	
	@Override
	public Object GetKey() {
		// TODO Auto-generated method stub
		return this.Key;
	}

	@Override
	public Object GetDisplayValue() {
		// TODO Auto-generated method stub
		return new Tuple(this.suit, this.rank);
	}	
	
	public void Print() {
		String[] lines = new String[9];
		IOWrapper.SysOutNL("┌───────┐");
		IOWrapper.SysOutNL(String.format("│%s     │",this.rank.GetDisplay())); 
		IOWrapper.SysOutNL("│       │");                                                                      
		IOWrapper.SysOutNL(String.format("│   %s  │",this.suit.GetDisplay()));                                                     
		IOWrapper.SysOutNL("│       │");                                                                      
		IOWrapper.SysOutNL(String.format("│     %s│",this.rank.GetDisplay()));                                                 
		IOWrapper.SysOutNL("└───────┘");
	}
}