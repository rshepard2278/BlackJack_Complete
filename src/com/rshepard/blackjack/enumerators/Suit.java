/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.enumerators;

/**
 *Suit enum creates the suits for a deck of cards
 *and adds an integer to process for card imaging
 */
public enum Suit {
	
	CLUBS(0),
	DIAMONDS(1),
	HEARTS(2),
	SPADES(3);
	
	private int suit;
	 
	/**
	 * @param suit
	 */
	Suit(int suit) {
		this.suit = suit;
	}
	
	/**
	 * @return The int value of the suit
	 */
	public int getValue() {
		return suit;
	}
}
