/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.game;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	
	private Stack<Card> deck;
	private Stack<Card> dealt;

	/**
	 * 
	 */
	public Deck() {
		deck = new Stack<>();
		dealt = new Stack<>();
		loadDeck();
	}
	
	private void loadDeck() {
		for(int i = 0; i < 52; i++){
			deck.push(new Card(i));
		}
	}
	
	public void shuffle() {
		shuffle(deck);
	}
	
	public void shuffle(Stack<Card> deckToShuffle) {
		Collections.shuffle(deckToShuffle);
	}
	
	public Card deal() {
		Card cardToDeal = null;
		if(!deck.isEmpty()) {
			cardToDeal = deck.pop();
			dealt.push(cardToDeal);
		} else {
			getNewDeck();
			cardToDeal = deck.pop();
		}
		return cardToDeal;
	}
	
	@SuppressWarnings("unchecked")
	private void getNewDeck() {
		shuffle(dealt);
		deck = (Stack<Card>)dealt.clone();
		dealt.clear();
	}
	
	public void printDeck() {
		for(Card c : deck) {
			System.out.println(c);
		}
	}
}
