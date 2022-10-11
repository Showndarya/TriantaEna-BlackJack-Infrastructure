package TriantaEna;

import java.util.Stack;

public class Deck {
	
	private Stack<Card> Cards;
	
	public void ShuffleCards() {
		Stack<Card> shuffled = new Stack<Card>();
		while(Cards.size()>0){
			int cardToPull = (int)(Math.random()*(Cards.size()-1));
			shuffled.add(Cards.get(cardToPull));
			Cards.remove(cardToPull);
		}
		this.Cards = shuffled;
	}
	
	public Card PickNextCard() {
		return Cards.pop();
	}
	

}
