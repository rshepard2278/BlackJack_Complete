/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.enumerators;

/**
 *Creates a numeric value for each card
 *in a deck
 */
public enum Value {
	
	ACE(0),
	TWO(1),
	THREE(2),
	FOUR(3),
	FIVE(4),
	SIX(5),
	SEVEN(6),
	EIGHT(7),
	NINE(8),
	TEN(9),
	JACK(10),
	QUEEN(11),
	KING(12);
	
	private int value;
	
	/**
	 * @param value Sets the value of this enum
	 */
	Value(int value) {
		this.value = value;
	}
	
	/**
	 * @return returns the value of the card
	 */
	public int getValue() {
		return value;
	}
}
