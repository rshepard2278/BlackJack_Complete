/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.states;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.interfaces.State;

/**
 * This class defines the Hit State
 */
public class HitState implements State {

	private BlackJackGame game;
	
	/**
	 * Creates a reference to the current game object
	 * @param game The current BlackJackGame object
	 */
	public HitState(BlackJackGame game) {
		this.game = game;
	}


	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.State#hit()
	 * Adds an additional card to the current player's hand
	 * and sets the state to the hitStand state
	 */
	public void hit() {
		game.getPlayer().addCard(game.getDeck().deal());
		game.setCurrentState(game.getHitStand());
	}
	

	@Override
	public void newGame() {}

	@Override
	public void deal() {}

	@Override
	public void bet() {}

	@Override
	public void hitStand() {}

	@Override
	public void stand() {}

	@Override
	public void dealerTurn() {}

	@Override
	public void checkWin() {}
}
