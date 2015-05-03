/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.states;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.interfaces.State;

/**
 * This class defines the HitStand state
 */
public class HitStandState implements State {

	
	/**
	 * @param game A reference to the current game object
	 */
	public HitStandState(BlackJackGame game) {}
	
	@Override
	public void hitStand() {}

	@Override
	public void newGame() {}

	@Override
	public void deal() {}

	@Override
	public void bet() {}

	@Override
	public void hit() {}

	@Override
	public void stand() {}

	@Override
	public void dealerTurn() {}

	@Override
	public void checkWin() {}
}
