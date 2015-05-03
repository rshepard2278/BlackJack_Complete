/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.interfaces;

import java.util.Stack;

import com.rshepard.blackjack.game.Card;

/**
 * Player interface used to set the general actions
 * of the players
 */
public interface Player {
	
	/**
	 * Adds a card to the current player's hand
	 * @param c Card object to add to the hand(stack)
	 */
	public void addCard(Card c);
	
	/**
	 * Gets the current hand of the player
	 * @return A Stack consisting of card objects
	 * of the current player
	 */
	public Stack<Card> getHand();
	
	/**
	 * Gets the name of the current player
	 * @return String of the player's name
	 */
	public String getName();
}
