package TriantaEna;

import Common.IOWrapper;
import Common.Tuple;
import GameObjects.Piece;
import TriantaEna.Enums.Rank;
import TriantaEna.Enums.Suit;

public class Card extends Piece {	
	private Rank rank;
	private Boolean FaceUp;	
	private Suit suit;
	
	public Card(int key, Rank rank, Suit suit) {
		this.Key=key;
		this.rank=rank;
		this.suit=suit;
		this.FaceUp = true;
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

	public Rank getRank() {
		return this.rank;
	}

	public Boolean isFaceUp() {
		return this.FaceUp;
	}

	public void setFaceUp(Boolean faceUp) {
		this.FaceUp = faceUp;
	}

	public void toggleFaceUp() {
		this.FaceUp = ! this.FaceUp;
	}

	private void printFaceDown() {
		
	}

	private void printFaceUp() {
		
	}
	
	public void Print() {
		if(this.FaceUp) {
			this.printFaceUp();
		} else {
			this.printFaceDown();
		}
	}
}