/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.interfaces;

/**
 *  State interface defines the overall functionality
 *  of the states of the game
 */
public interface State {
	
	/**
	 *  Defines the newGame action
	 */
	public void newGame();
	
	/**
	 *  Defines the deal action
	 */
	public void deal();
	
	/**
	 *  Defines the bet action
	 */
	public void bet();
	
	/**
	 * Defines the hit or stand action
	 */
	public void hitStand();
	
	/**
	 * Defines the hit action
	 */
	public void hit();
	
	/**
	 * Defines the stand action
	 */
	public void stand();
	
	/**
	 * Defines the dealerTurn action
	 */
	public void dealerTurn();
	
	/**
	 * Defines the checkWin action
	 */
	public void checkWin();
}
