/**
 * @author Richard Shepard
 * @version Apr 24, 2015
 */
package com.rshepard.blackjack.gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.rshepard.blackjack.game.BlackJackGame;

/**
 * A JPanel for the bottom of the GUI that displays the player's
 * remaining money(wallet), the current pot, and the winner of 
 * the game
 */
public class InfoPanel extends JPanel {


	private static final long serialVersionUID = -5898378813867112142L;
	private BlackJackGame game;
	private JLabel info;
	private JLabel wallet;
	private static final String WALLET_TEXT = "You have: $";
	private int walletAmount;



	/**
	 * Creates a new info panel and sets the default
	 * messages
	 * @param game A reference to the current BlackJackGame object
	 * used for checking the current state of the game
	 */
	public InfoPanel(BlackJackGame game) {
		this.game = game;
		setLayout(new FlowLayout());
		walletAmount =  game.getPlayer().getWallet();
		wallet = new JLabel(WALLET_TEXT + walletAmount);
		info = new JLabel("Please make a bet");
		add(wallet);
		add(info);
	}
	
	/**
	 * Updates the text on the GUI
	 * @param text String value of the text to be
	 * drawn on the screen
	 */
	public void setText(String text) {
		wallet.setText(WALLET_TEXT + game.getPlayer().getWallet()); 
		info.setText(text);
	}
}
