package TriantaEna;

import java.util.Stack;

import TriantaEna.Enums.Rank;
import TriantaEna.Enums.Suit;

public class Deck {
	
	private static Stack<Card> Cards=new Stack<Card>();
	
	public static void InitCards() {
		int id=0;
		for(int i=0;i< Suit.values().length;i++){
			for(int j=0;j< Rank.values().length;j++) {
				Cards.add(new Card(id,Rank.values()[j],Suit.values()[i]));
				id++;
			}
		}
	}
	
	public static void ShuffleCards() {
		Stack<Card> shuffled = new Stack<Card>();
		while(Cards.size()>0){
			int cardToPull = (int)(Math.random()*(Cards.size()-1));
			shuffled.add(Cards.get(cardToPull));
			Cards.remove(cardToPull);
		}
		Cards = shuffled;
	}
	
	public static Card PickNextCard() {
		return Cards.pop();
	}
	

}
