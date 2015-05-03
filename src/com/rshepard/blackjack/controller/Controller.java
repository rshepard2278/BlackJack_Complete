/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.controller;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.gui.GUI;
import com.rshepard.blackjack.states.StandState;

/**
 *Controller handles the flow of the blackjack game
 *with a game loop that is exit once the user closes the 
 *window, clicks quit, or runs out of money
 */
public class Controller {

	private BlackJackGame game;
	private GUI gui;

	/**
	 * Instantiates a new game controller
	 */
	public Controller() {
		game = new BlackJackGame();        
	}
	
	/**
	 * Begins a gameloop of blackjack
	 */
	public void play() {
		gui = new GUI();
		while(true) {
			game.newGame();
			game.deal();
			gui.loadTable(game);
			game.bet();
			gui.getInput();
			while(!(game.getState() instanceof StandState)) {
				gui.getInput();
			}
			game.stand();			
			while(!game.isWon()) {
				game.dealerTurn();
			}
			game.checkWin();
			gui.setInfoText(game.getWinner());
			gui.getInput();
		}
	}
}
