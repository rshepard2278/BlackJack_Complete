/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.game;

import java.util.Stack;

import com.rshepard.blackjack.interfaces.Player;

/**
 * This class models the Human player in a game of blackjack
 * with a stack for the hand, an int for the wallet, and a
 * string for the name
 */
public class HumanPlayer implements Player{

	
	private Stack<Card> hand;
	private int wallet;
	private String name;
	
	/**
	 * Creates an object of type player
	 * sets the name to "Player",
	 * the wallet to 200, and creates
	 * a new stack for the hand
	 */
	public HumanPlayer() {
		name = "Player";
		wallet = 200;
		hand = new Stack<>();
	}
	
	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.Player#addCard(com.rshepard.blackjack.game.Card)
	 * Adds a card to the player's hand
	 * @param The card object to be added to the hand
	 */
	public void addCard(Card c) {
		hand.add(c);
	}
	
	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.Player#getHand()
	 * Gets the hand of the player
	 * @return A stack consisting of the cards of the player's hand
	 */
	public Stack<Card> getHand() {
		return hand;
	}
	
	/**
	 * Adds the winnings to the player's wallet
	 * @param winnings An integer to add to the player's wallet
	 */
	public void addToWallet(int winnings) {
		wallet += winnings;
	}
	
	/**
	 * Clears the player's current hand
	 */
	public void clearHand() {
		hand.clear();
	}

	/**
	 * Gets the value of the player's current wallet
	 * @return An int value of the wallet
	 */
	public int getWallet() {
		return wallet;
	}
	
	/**
	 * Subtracts the player's current bet from the wallet
	 * @param bet An int of the bet to be removed from the 
	 * player's wallet
	 */
	public void subtractBet(int bet) {
		wallet -= bet;
	}

	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.Player#getName()
	 * @return The String value of the player's name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @return The String value of the player object
	 */
	public String toString() {
		return "HumanPlayer [name=" + name + "]";
	}

}
