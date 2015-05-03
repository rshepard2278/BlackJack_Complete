/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.states;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.interfaces.State;

/**
 * This class defines the Stand state
 */
public class StandState implements State {

	private BlackJackGame game;
	
	/**
	 * Sets a reference to the current game
	 * @param game The BlackJackGame object to be referenced
	 */
	public StandState(BlackJackGame game) {
		this.game = game;
	}
	
	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.State#stand()
	 * Sets the current state to DealerTurn
	 */
	@Override
	public void stand() {
		game.setCurrentState(game.getDealerTurn());
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
	public void hit() {}

	@Override
	public void dealerTurn() {}

	@Override
	public void checkWin() {}
}
