package TriantaEna;

public class Cell extends GameObjects.Cell {
	public Cell() {
		this.WinWhenStarted = 0;
	}
	
	public Card GetValue() {
		return (Card)this.Value;
	}
	
	public void SetValue(Card value) {
		this.Value = value;
	}

	public void printCell() {
		if(this.Value != null) {
			Card card = (Card) this.Value;
			card.Print();
		}
	}

}