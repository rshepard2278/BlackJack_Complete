/**
 * @author Richard Shepard
 * @version Apr 24, 2015
 */
package com.rshepard.blackjack.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.rshepard.blackjack.game.BlackJackGame;
import com.rshepard.blackjack.interfaces.State;
import com.rshepard.blackjack.states.BetState;
import com.rshepard.blackjack.states.CheckWinState;
import com.rshepard.blackjack.states.HitStandState;
import com.rshepard.blackjack.states.HitState;

/**
 * This class simulates a graphical version of a table for 
 * a game of blackjack and the proper user interface buttons used
 * for game play. It uses two nested inner classes to create the buttons
 * and actionlisteners for them
 */
public class TablePanel extends JPanel {


	private static final long serialVersionUID = 1989543996671905440L;
	private HandDisplay dealer;
	private HandDisplay player;
	private InfoPanel info;
	private ButtonPanel buttonPanel;
	private BlackJackGame game;
	private GuiActionListener listener;
	private boolean buttonPressed;
	private JTextArea betAmount;
	private static final String BET_STRING = "Bet: $";
	private static final String PLAY_AGAIN = "Play Again";
	private static final String QUIT = "Quit";
	private static final String HIT = "Hit";
	private static final String STAND = "Stand";

	
	/**
	 * Creates a new TablePanel, references the current game,
	 * sets the layout manager, and creates UI buttons and listeners
	 * @param game The current game to be played
	 */
	public TablePanel(BlackJackGame game) {
		this.game = game;
		buttonPressed = false;
		listener = new GuiActionListener();
		setLayout(new BorderLayout());
		addPanels();
	}
	
	/**
	 *  Adds the handDisplay panels, info panel, and button
	 *  panel to the GUI 
	 */
	private void addPanels() {
		dealer = new HandDisplay(game.getDealer(), game);
		player = new HandDisplay(game.getPlayer(), game);
		info = new InfoPanel(game);
		buttonPanel = new ButtonPanel();
		JPanel hands = new JPanel();
		hands.setLayout(new GridLayout(2, 0));
		hands.add(dealer);
		hands.add(player);		
		hands.setBackground( new Color(130,50,40) );
		add(hands, BorderLayout.CENTER);
		add(info, BorderLayout.SOUTH);
		add(buttonPanel, BorderLayout.EAST);
	}
	
	/**
	 * Pauses and waits for a user interaction
	 */
	public void waitForClick() {
		while(!buttonPressed) {
			sleep(20);
		}
		repaint();
		buttonPressed = false;
	}
	
	/**
	 * Pauses the current thread for 
	 * a given amount of time
	 * @param Int value of the number of milliseconds
	 * to pause for
	 */
	private void sleep(int milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Gets the current bet from the BlackJack game
	 *  object and updates the betText at the bottom
	 *  of the GUI
	 */
	private void updateBetText() {
		betAmount.setText(BET_STRING + game.getPot());
	}
	
	/**
	 * Updates the info text at the bottom 
	 * of the GUI
	 * @param text String of text to be drawn on the 
	 * screen
	 */
	public void updateInfo(String text) {
		info.setText(text);
	}
	
	/**
	 * Validates the bet amount input by the user
	 * and updates the display text with the
	 * appropriate message after validating the bet
	 * with the game object
	 */
	private void validateBet() {
		if(game.getState() instanceof BetState) {
			if(game.isBetValid()) {
				buttonPressed = true;
				game.setCurrentState(game.getHitStand());
				updateInfo("You bet: $" + game.getPot());
			} else {
				updateInfo("Bet is too high. Select a different amount");
				betAmount.setText(BET_STRING + 0);
				game.setPot(0);
			}
		}
	}

	/**
	 *  Nested inner class that handles the actions taken
	 *  by the user
	 */
	public class GuiActionListener implements ActionListener {
		
		/**
		 * Creates a new GuiActionListener object
		 */
		public GuiActionListener() {}

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * Handles the actions that are taken by the user when a specific
		 * button is pressed and validates the response with a reference to 
		 * the game object
		 */
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch(command) {
				case "Bet": 
					validateBet();
					break;
				case STAND:
					if(game.getState() instanceof HitStandState || game.getState() instanceof HitState) {
						updateInfo("You chose to stand with" + game.getPlayerScore() + ". Dealer's turn");
						game.setCurrentState(game.getStand());
						buttonPressed = true;
					}
					break;
				case HIT:
					if(game.getState() instanceof HitStandState) {
						game.setCurrentState(game.getHit());
						game.hit();
						buttonPressed = true;
					}
					break;
				case "$5":
					if(game.getState() instanceof BetState) {
						game.setPot(game.getPot() + 5);
					}
					updateBetText();;
					break;
				case "$10":
					if(game.getState() instanceof BetState) {
						game.setPot(game.getPot() + 10);
					}
					updateBetText();;
					break;
				case "$20":
					if(game.getState() instanceof BetState) {
						game.setPot(game.getPot() + 20);
					}
					updateBetText();;
					break;
				case "$50":
					if(game.getState() instanceof BetState) {
						game.setPot(game.getPot() + 50);
					}
					updateBetText();;
					break;
				case "$100":
					if(game.getState() instanceof BetState) {
						game.setPot(game.getPot() + 100);
					}
					updateBetText();;
					break;
				case QUIT:
					System.exit(0);
					break;
				case PLAY_AGAIN:
					if(game.getPlayer().getWallet() <= 0) {
						JOptionPane.showMessageDialog(getParent(), "You're Out of Money");
						System.exit(0);
					}
					game.setCurrentState(game.getNewGame());
					buttonPressed = true;
			}
			repaint();
		}
	}
	
	
	/**
	 *  This nested inner class creates all the UI buttons and 
	 *  registers the GuiActionListener to those buttons
	 */
	public class ButtonPanel extends JPanel {

	
		private static final long serialVersionUID = -1143648058828481353L;
		
		private JButton bet;
		private JButton stand;
		private JButton hit;
		private JButton five;
		private JButton ten;
		private JButton twenty;
		private JButton fifty;
		private JButton hundred;
		
		/**
		 *  Creates a new ButtonPanel object, sets the layout,
		 *  and adds the buttons to the panel
		 */
		public ButtonPanel() {
			setLayout(new GridLayout(9, 0));
			setBorder(BorderFactory.createEtchedBorder());
			initButtons();
			addButtons();
			addListeners();
		}
		
		/**
		 *  Initializes all the buttons with the proper text
		 */
		private void initButtons() {
			bet = new JButton("Bet");
			stand = new JButton(STAND);
			hit = new JButton(HIT);
			five = new JButton("$5");
			ten = new JButton("$10");
			twenty = new JButton("$20");
			fifty = new JButton("$50");
			hundred = new JButton("$100");
			hundred.setBorderPainted(true);
			betAmount = new JTextArea();
			betAmount.setText(BET_STRING + game.getPot());
		}
		
		/**
		 *  Adds the buttons to the panel
		 */
		private void addButtons() {
			add(bet);
			add(betAmount);
			add(five);
			add(ten);
			add(twenty);
			add(fifty);
			add(hundred);
			add(stand);
			add(hit);
		}

		/**
		 *  Adds the GuiActionListener to all 
		 *  the buttons
		 */
		private void addListeners() {
			bet.addActionListener(listener);
			stand.addActionListener(listener);
			hit.addActionListener(listener);
			five.addActionListener(listener);
			ten.addActionListener(listener);
			twenty.addActionListener(listener);
			fifty.addActionListener(listener);
			hundred.addActionListener(listener);
		}
		
		/**
		 * Sets whether the bet buttons are enable
		 * @param Boolean value that dictates whether 
		 * or not the bet buttons are enabled
		 */
		private void enableBetButtons(boolean set) {
			bet.setEnabled(set);
			five.setEnabled(set);
			ten.setEnabled(set);
			fifty.setEnabled(set);
			twenty.setEnabled(set);
			hundred.setEnabled(set);
		}
		
		/**
		 * Sets whether the hit and stand buttons are 
		 * enabled
		 * @param Boolean value that dictates whether or
		 * not the hit and stand buttons are enabled
		 */
		private void enableHitStandButtons(boolean set) {
			hit.setEnabled(set);
			stand.setEnabled(set);
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 * Paints the proper buttons and text depending on the 
		 * state of the current game
		 * @param Graphics context used for drawing objects on the 
		 * screen
		 */
		public void paintComponent(Graphics g) {
			State current = game.getState();
			if(current instanceof BetState) {
				enableBetButtons(true);
				enableHitStandButtons(false);
			} else {
				enableBetButtons(false);
				enableHitStandButtons(true);
			}
			if(current instanceof CheckWinState) {
				stand.setText(PLAY_AGAIN);
				hit.setText(QUIT);
			} else {
				stand.setText(STAND);
				hit.setText(HIT);
			}
		}
	}
}
