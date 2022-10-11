package TriantaEna;

import java.util.ArrayList;

public class Hand {
	
	private int CurrentValue;
	private ArrayList<Card> CurrentCards;
	
	public Hand() 
	{
		this.CurrentCards=new ArrayList<Card>();
		this.CurrentValue=0;
	}
	
	public ArrayList<Card> GetCurrentCards(){
		return this.CurrentCards;
	}
	
	public int GetCurrentValue(){
		return this.CurrentValue;
	}
	
	public void AddValue(int value) {
		this.CurrentValue+=value;
	}
	
	public void AddCard(Card card) {
		this.CurrentCards.add(card);
	}
}
