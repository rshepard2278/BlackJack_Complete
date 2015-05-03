/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.game;

import com.rshepard.blackjack.controller.Controller;

/**
 * This class starts a game of BlackJack
 */
public class StartGame {

	/**
	 * Main method to begin the application
	 * @param args Command line parameters
	 */
	public static void main(String[] args) {
		Controller gameController = new Controller();
		gameController.play();	
	}
}
