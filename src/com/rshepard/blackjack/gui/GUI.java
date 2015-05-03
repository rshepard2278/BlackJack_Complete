/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.rshepard.blackjack.game.BlackJackGame;

/**
 * This class creates the overall GUI for 
 * a game of blackjack
 */
public class GUI extends JFrame {

	private static final long serialVersionUID = 507860267620863810L;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 400;
	private TablePanel gameTable;


	/**
	 *  Creates a JFrame and sets the title bar
	 */
	public GUI() {
		super("Black Jack Table");
	}
	
	/**
	 * Loads the blackjack game into the GUI by setting the 
	 * content, size, and characteristics of the frame.
	 * @param game The BlackJackGame object to be loaded into the GUI
	 */
	public void loadTable(BlackJackGame game) {
		gameTable = new TablePanel(game);
		setContentPane(gameTable);
		pack();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( (screensize.width - getWidth())/4, (screensize.height - getHeight())/4);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}
	
	/**
	 *  Starts a loop in the gametable that waits for
	 *  an input from the user
	 */
	public void getInput() {
		gameTable.waitForClick();
	}
	
	/**
	 * Displays custom messages and the bottom
	 * of the GUI
	 * @param text String of text to be displayed in
	 * the bottom left hand corner of the GUI
	 */
	public void setInfoText(String text) {
		gameTable.updateInfo(text);
	}

}
