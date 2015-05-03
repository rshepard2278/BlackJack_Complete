/**
 * @author Richard Shepard
 * @version May 1, 2015
 */
package com.rshepard.blackjack.game;

import java.util.ArrayList;

import com.rshepard.blackjack.interfaces.Player;

/**
 * This class handles the evaluating and ranking
 * of a hand of blackjack
 */
public class HandRank {
	
	private static final int BLACKJACK = 21;
	private static final int BUST = 0;
	private ArrayList<Integer> hand;
	
	/**
	 *  Creates an instance of HandRank
	 */
	public HandRank() {}

	/**
	 * Determines the value of the players hand
	 * and returns the rank
	 * @param player The player object to be evaluated
	 * @return Returns an integer value of the hand rank
	 */
	public int checkHand(Player player) {
		getValues(player);
		return getRank();
	}
	
	/**
	 * Gets the cumulative value of the players hand
	 * @param The player object to be evaluated
	 */
	private void getValues(Player player) {
		hand = new ArrayList<>();
		for(Card c : player.getHand()) {
			if(c.getValue() < 10) {
				if(c.getValue() == 0) {
					hand.add(11);
				} else {
					hand.add(c.getValue() + 1);
				}
			} else {
				hand.add(10);
			}
		}
	}
	
	/**
	 * Uses the value of the hand to determine a 
	 * blackjack score
	 * @return Returns the value of the hand if it is less
	 * than or equal to 21. Zero if the hand is bust
	 */
	private int getRank() {
		int rank = 0;
		int score = 0;
		for(Integer i : hand) {
			score += i;
		}
		if(score <= BLACKJACK) {
			rank = score;
		} else {
			rank = checkForAce();
		}
		return rank;
	}
	
	/**
	 * Checks for an ace and adjusts the players score only
	 * if it is over 21
	 * @return Returns the new rank for the hand only if
	 * the hand contains an ace and is over 21
	 */
	private int checkForAce() {
		int rank = 0;
		for(Integer i : hand) {
			if(i == 11) {
				rank += 1;
			} else {
				rank += i;
			}
		}
		if(rank > BLACKJACK) {
			rank = BUST;
		}
		return rank;
	}
}
