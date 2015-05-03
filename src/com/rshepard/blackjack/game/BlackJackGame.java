/**
 * @author Richard Shepard
 * @version Apr 23, 2015
 */
package com.rshepard.blackjack.game;

import com.rshepard.blackjack.interfaces.State;
import com.rshepard.blackjack.states.BetState;
import com.rshepard.blackjack.states.CheckWinState;
import com.rshepard.blackjack.states.DealState;
import com.rshepard.blackjack.states.DealerTurnState;
import com.rshepard.blackjack.states.HitStandState;
import com.rshepard.blackjack.states.HitState;
import com.rshepard.blackjack.states.NewGameState;
import com.rshepard.blackjack.states.StandState;

/**
 *Simulates the different states of a 
 *game of blackJack.  I experimented with
 *using the state machine design pattern
 */
public class BlackJackGame {
	
	private Dealer dealer;
	private HumanPlayer player;
	private Deck deck;
	private int pot;
	private boolean isWon;
	private HandRank ranker;
	
	private State currentState;
	
	private State bet;
	private State checkWin;
	private State deal;
	private State dealerTurn;
	private State hit;
	private State hitStand;
	private State newGame;
	private State stand;

	/**
	 * Creates a new blackjack instance and initializes
	 * all the possible states
	 */
	public BlackJackGame() {
		ranker = new HandRank();
		deck = new Deck();
		initStates();
	}
	
	/**
	 * Loads two players (dealer, player)
	 */
	public void loadPlayers() {
		if(player == null) {
			player = new HumanPlayer();
		} else {
			player.clearHand();
		}
		dealer = new Dealer();
	}
	
	/**
	 * Initializes all the different states
	 * of the game and registers this instance
	 * of blackjack for a reference in each state
	 */
	private void initStates() {
		bet = new BetState(this);
		checkWin = new CheckWinState(this);
		deal = new DealState(this);
		dealerTurn = new DealerTurnState(this);
		hit = new HitState(this);
		hitStand = new HitStandState(this);
		newGame = new NewGameState(this);
		stand = new StandState(this);
	}
	
	/**
	 * @return If the value of the bet is valid when
	 * compared to the player's remaining amount in their
	 * wallet
	 */
	public boolean isBetValid() {
		boolean betValid = false;
		if(pot <= player.getWallet()) {
			player.subtractBet(pot);
			betValid = true;
		} else {
			betValid = false;
		}
		return betValid;
	}
	
	/**
	 * @return The boolean indicating whether or 
	 * not the game has been won
	 */
	public boolean isWon() {
		return isWon;
	}
	
	/**
	 * @return Uses the Ranker class to check the score
	 * of the Player and returns an int value of the hand
	 */
	public int getPlayerScore() {
		return ranker.checkHand(player);
	}
	
	/**
	 * @return Uses the Ranker class to check the score
	 * of the Dealer and returns an int value of the hand
	 */
	public int getDealerScore() {
		return ranker.checkHand(dealer);
	}
	
	/**
	 * Begins a new game of blackjack inits the
	 * pot to zero and isWon to false and sets the
	 * current state to new game and calls that method
	 */
	public void newGame() {
		isWon = false;
		pot = 0;
		currentState = newGame;
		currentState.newGame();
	}
	
	/**
	 * Calls the bet method of the current state
	 */
	public void bet() {
		currentState.bet();
	}
	
	/**
	 * Calls the checkWin method of the current state
	 */
	public void checkWin() {
		currentState.checkWin();
	}
	
	/**
	 * Calls the deal method of the current state
	 */
	public void deal() {
		currentState.deal();
	}
	
	/**
	 * Calls the playerTurn method of the current state
	 */
	public void playerTurn() {
		currentState.bet();
	}
	
	/**
	 * Calls the hitStand method of the current state
	 */
	public void hitStand() {
		currentState.hitStand();
	}
	
	/**
	 * Calls the hit method of the current state
	 */
	public void hit() {
		currentState.hit();
	}
	
	/**
	 * Calls the stand method of the current state
	 */
	public void stand() {
		currentState.stand();
	}
	
	/**
	 * Calls the dealerTurn method of the current state
	 * and makes sure isWon is false
	 */
	public void dealerTurn() {
		isWon = false;
		currentState.dealerTurn();
	}
	
	/**
	 * @return The string value of the winner and sets the
	 * proper payout
	 */
	public String getWinner() {
		String winnerText = "Winner: ";
		String winner = "";
		int pScore = ranker.checkHand(player);
		int dScore = ranker.checkHand(dealer);
		if(dScore >= pScore) {
			winner += "Dealer";
		} else {
			winner += "Player";
		} 
		payout(winner);
		return winnerText + winner;
	}
	
	/**
	 * @param The string of the winner, if 
	 * the winner is the player it pays out 
	 * the pot times two to the players wallet
	 */
	private void payout(String winner) {
		if(winner.equals("Player")) {
			player.addToWallet(pot * 2);
		}
	}

	/**
	 * @return Returns the currentState of the game
	 */
	public State getState() {
		return currentState;
	}

	/**
	 * @param currentState the currentState to set of the game
	 */
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	/**
	 * @return Returns the dealer
	 */
	public Dealer getDealer() {
		return dealer;
	}

	/**
	 * @return Returns the player
	 */
	public HumanPlayer getPlayer() {
		return player;
	}

	/**
	 * @return Returns the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @return Returns the bet state
	 */
	public State getBet() {
		return bet;
	}

	/**
	 * @return Returns the checkWin state
	 */
	public State getCheckWin() {
		return checkWin;
	}

	/**
	 * @return Returns the deal state
	 */
	public State getDeal() {
		return deal;
	}

	/**
	 * @return Returns the dealerTurn state
	 */
	public State getDealerTurn() {
		return dealerTurn;
	}

	/**
	 * @return Returns the hit state
	 */
	public State getHit() {
		return hit;
	}

	/**
	 * @return Returns the hitStand state
	 */
	public State getHitStand() {
		return hitStand;
	}

	/**
	 * @return Returns the newGame state
	 */
	public State getNewGame() {
		return newGame;
	}

	/**
	 * @return Returns the stand state
	 */
	public State getStand() {
		return stand;
	}

	/**
	 * @return Returns an integer value of the pot
	 */
	public int getPot() {
		return pot;
	}

	/**
	 * @param pot Sets the value of the pot
	 */
	public void setPot(int pot) {
		this.pot = pot;
	}

	/**
	 * @param isWon Boolean value to set true
	 * if the game has been won
	 */
	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}

}
