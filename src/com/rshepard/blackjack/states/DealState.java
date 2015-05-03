/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.states;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.game.Deck;
import com.rshepard.blackjack.interfaces.State;

/**
 * This class defines the actions of the Deal State
 */
public class DealState implements State {

	private BlackJackGame game;

	/**
	 * Sets a reference to the current game
	 * @param game Current BlackJackGame object to reference to
	 */
	public DealState(BlackJackGame game) {
		this.game = game;
	}
	
	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.State#deal()
	 * Deals the cards to the players using the deck from the
	 * current game and sets the state to bet
	 */
	@Override
	public void deal() {
		Deck deck = shuffleDeck();
		dealCards(deck);
		game.setCurrentState(game.getBet());
	}
	
	/**
	 * Shuffles and returns the deck
	 * @return The shuffled deck to be used
	 */
	private Deck shuffleDeck() {
		game.getDeck().shuffle();
		return game.getDeck();		
	}
	
	/**
	 * Deals the cards to the players
	 * @param The Deck object to deal from
	 */
	private void dealCards(Deck deck) {
		for(int i = 0; i < 2; i++) {
			game.getPlayer().addCard(game.getDeck().deal());
			game.getDealer().addCard(game.getDeck().deal());
		}
	}
	
	@Override
	public void newGame() {}
	
	@Override
	public void bet() {}

	@Override
	public void hitStand() {}

	@Override
	public void hit() {}

	@Override
	public void stand() {}

	@Override
	public void dealerTurn() {}

	@Override
	public void checkWin() {}
}
