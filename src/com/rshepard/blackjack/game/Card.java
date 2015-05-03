/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.game;

import com.rshepard.blackjack.enumerators.Suit;
import com.rshepard.blackjack.enumerators.Value;

/**
 *An object that simulates a typical playing
 *card with a suit and a value
 */
public class Card {
	
	private int cardNumber;
	private Suit suit;
	private Value value;


	/**Creates a new card based upon the card number and
	 * uses that number to set the suit and the value
	 * @param cardNumber A number between 0 and 52 that
	 * dictates the suit and value of the card. If the 
	 * card number is not valid and default value of
	 * the Ace of Clubs is set
	 */
	public Card(int cardNumber) {
		if(cardNumber >= 0 && cardNumber < 53) {
			this.cardNumber = cardNumber;
			setSuit();
			setValue();
		} else {
			suit = Suit.CLUBS;
			value = Value.ACE;
		}
	}

	/**
	 * Uses the cardNumber passed in the constructor
	 * to determine the suit by dividing that number
	 * by 13 to get a value between 0 and 3, inclusive.
	 */
	private void setSuit() {
		int suitValue = cardNumber / 13;
		for(Suit s : Suit.values()) {
			if(s.getValue() == suitValue) {
				suit = s;
			}
		}
	}
	
	/**
	 * Uses the cardNumber passed in the constructor
	 * to determine the value by dividing that number
	 * by 4 to get a value between 0 and 12, inclusive.
	 * Aces = 0
	 * two = 1
	 * ...
	 * kings = 12
	 */
	private void setValue() {
		int valueInt = cardNumber % 13;
		for(Value v : Value.values()) {
			if(v.getValue() == valueInt) {
				value = v;
			}
		}
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @return The String value of the card
	 * inn the format of value of suit 
	 * ie. Ace of Spades
	 */
	public String toString() {
		return (value + " of " + suit);
	}

	/**
	 * @return Returns the integer value of the suit
	 */
	public int getSuit() {
		return suit.getValue();
	}

	/**
	 * @return Returns the integer value of the card value
	 */
	public int getValue() {
		return value.getValue();
	}
}
