/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.states;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.interfaces.State;

/**
 * This class defines the Betting State
 */
public class BetState implements State {

	/**
	 * @param game A reference to the current game object
	 */
	public BetState(BlackJackGame game) {}
	
	@Override
	public void bet() {}

	@Override
	public void checkWin() {}

	@Override
	public void hitStand() {}
	
	@Override
	public void newGame() {}

	@Override
	public void deal() {}
	
	@Override
	public void hit() {}

	@Override
	public void stand() {}

	@Override
	public void dealerTurn() {}
}
