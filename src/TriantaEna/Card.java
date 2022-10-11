package TriantaEna;

import GameObjects.Piece;

public class Card extends Piece {
	
	private int FaceValue;
	
	public Card(int key, int value, String displayValue) {
		this.Key=key;
		this.FaceValue=value;
		this.DisplayValue=displayValue;
	}
	
	@Override
	public int GetKey() {
		// TODO Auto-generated method stub
		return this.Key;
	}

	@Override
	public Object GetDisplayValue() {
		// TODO Auto-generated method stub
		return this.DisplayValue;
	}
	
	public Object GetFaceValue() {
		// TODO Auto-generated method stub
		return this.FaceValue;
	}
	
}                                                                  