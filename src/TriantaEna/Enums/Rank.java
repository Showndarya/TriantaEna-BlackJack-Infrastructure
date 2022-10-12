package TriantaEna.Enums;

public enum Rank {
	Ace(1,"A"),
	Two(2,"2"),
	Three(3,"3"),
	Four(4,"4"),
	Five(5,"5"),
	Six(6,"6"),
	Seven(7,"7"),
	Eight(8,"8"),
	Nine(9,"9"),
	Ten(10,"10"),
	Jack(10,"J"),
	Queen(10,"Q"),
	King(10,"K");
	
	int value;
	String display;
	
	Rank(int value, String display) {
		this.value=value;
		this.display=display;
	}
	
	public String toString() {
		return this.name();
	}
	
	public int GetValue() {
		return this.value;
	}
	
	public String GetDisplay() {
		return this.display;
	}

}
