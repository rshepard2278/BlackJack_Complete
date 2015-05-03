/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.states;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.interfaces.State;

/**
 *This class defines the NewGame state
 */
public class NewGameState implements State {

	private BlackJackGame game;

	/**
	 * Sets a reference to the current game
	 * @param game The BlackJackGame to be referenced
	 */
	public NewGameState(BlackJackGame game) {
		this.game = game;
	}


	/* (non-Javadoc)
	 * @see com.rshepard.blackjack.interfaces.State#newGame()
	 * Loads the two players and sets the state to deal
	 */
	public void newGame() {
		game.loadPlayers();
		game.setCurrentState(game.getDeal());
	}
	
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

	@Override
	public void checkWin() {}
}
