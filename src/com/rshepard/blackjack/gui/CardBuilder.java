/**
 * @author Richard Shepard
 * @version Apr 24, 2015
 */
package com.rshepard.blackjack.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.rshepard.blackjack.game.Card;

/**
 * This class builds the visual card objects to be used in
 * the game. It does so by cropping out a smaller image from
 * a base image of a complete deck of cards
 */
public class CardBuilder {
	
	private BufferedImage deckPic;

	/**
	 *  Creates an instance of a CardBuilder
	 */
	public CardBuilder() {
		loadCards();
	}
	
	//
	//
	/**
	 * Uses the value of the card to calculate the coordinates of the deck image
	 * to crop out that card. Some of this method I didn't create on my own. I must
	 * give some of the credit to the author of the book "Intro to Programming Using Java"
	 * @param card The card that is to be displayed
	 * @return A buffered image of the card that is passed
	 * as a parameter
	 */
	public BufferedImage getCardImage(Card card) {
		int cx; // x-coord of upper left corner of the card inside cardsImage
		int cy; // y-coord of upper left corner of the card inside cardsImage		
		if (card == null) {
			cy = 4 * 123; // coords for a face-down card.
			cx = 2 * 79;
		} else {
			cx = (card.getValue()) * 79;
			switch (card.getSuit()) {
			case 0:
				cy = 0;
				break;
			case 1:
				cy = 123;
				break;
			case 2:
				cy = 2 * 123;
				break;
			default: // spades
				cy = 3 * 123;
				break;
			}
		}
		return deckPic.getSubimage(cx, cy, 79, 123);
	}	
	

	/**
	 * Loads the image of the deck to be used to crop out
	 * specific cards. Image provided by the 
	 * book "Intro to Programming Using Java"
	 */
	private void loadCards() {
		URL urlToFile = this.getClass().getResource("cards.png");
		try {
			deckPic = ImageIO.read(urlToFile);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
