package GameObjects;

public abstract class Piece {	
	/*
	 * Abstract class to hold functions related to getting internal and display value for each piece (game piece).
	 */
	 protected int Key = 0;	 
	 protected String DisplayValue = "";	 
	 
	 public abstract Object GetKey();	 
	 public abstract Object GetDisplayValue();
}
