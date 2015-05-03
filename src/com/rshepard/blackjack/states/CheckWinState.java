/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.states;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.interfaces.State;

/**
 * This class defines the checkWinState
 */
public class CheckWinState implements State {

	/**
	 * @param game A reference to the current game
	 */
	public CheckWinState(BlackJackGame game) {}
	
	@Override
	public void checkWin() {}
	
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
	public void stand() {}

	@Override
	public void dealerTurn() {}
}
