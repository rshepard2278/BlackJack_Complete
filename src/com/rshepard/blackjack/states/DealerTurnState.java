/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.states;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.interfaces.State;

/**
 * This class defines the DealerTurn state
 */
public class DealerTurnState implements State {
	
	
	private BlackJackGame game;
	
	/**
	 * Initializes a reference to the current game
	 * @param game The BlackJackGame object to reference
	 */
	public DealerTurnState(BlackJackGame game) {
		this.game = game;
	}
	
	/**
	 * Checks the value of the dealer's and the
	 * player's cards
	 */
	public void dealerTurn() {
		checkCards();
	}
	
	/**
	 *  Handles the AI of the dealer. Stands on 17
	 *  or higher. Also determines if the dealers turn is
	 *  over and changes to the appropriate game state
	 */
	private void checkCards() {
		double playerScore = game.getPlayerScore();
		double dealerScore = game.getDealerScore();
		if(dealerScore != 0) {
			if((playerScore == 0) || dealerScore >= 17) {
				game.setWon(true);
				game.setCurrentState(game.getCheckWin());
			} else if(dealerScore < 17 && dealerScore > 0) {
				game.getDealer().addCard(game.getDeck().deal());
			}
		} else {
			game.setWon(true);
			game.setCurrentState(game.getCheckWin());
		}
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
	public void stand() {}

	@Override
	public void checkWin() {}
}
