/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.game;

import java.util.Stack;

import com.rshepard.blackjack.interfaces.Player;

/**
 *This class models the dealer of a game of blackjack.
 *Has only two member variables: a Stack for a hand of cards and
 *a String for identification (Does not deal the cards).  Implements
 *the player interface.
 */
public class Dealer implements Player{

	private Stack<Card> hand;
	private String name;
	
	
	/**
	 * Creates an instance of a dealer object
	 * by setting the name and creating a new
	 * hand(Stack)
	 */
	public Dealer() {
		name = "Dealer";
		hand = new Stack<>();
	}
	
	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.Player#addCard(com.rshepard.blackjack.game.Card)
	 * @param Card adds a card to the hand
	 */
	public void addCard(Card c) {
		hand.add(c);
	}
	
	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.Player#getHand()
	 * @return Returns a stack that is the dealers hand
	 */
	public Stack<Card> getHand() {
		return hand;
	}

	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.Player#getName()
	 * @return The string value of this player
	 */
	public String getName() {
		return name;
	}	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @return the string value of this object
	 */
	public String toString() {
		return "Dealer [name=" + name + "]";
	}
}
