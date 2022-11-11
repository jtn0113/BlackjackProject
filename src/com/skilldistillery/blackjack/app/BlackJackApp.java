package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cardgame.BlackjackHand;
import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp {
	private Deck deck = new Deck();
	private BlackjackHand playerHand = new BlackjackHand();
	private BlackjackHand dealerHand = new BlackjackHand();
	private Dealer dealer = new Dealer(deck, dealerHand);
	private Player player = new Player(playerHand);

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		Scanner scanner = new Scanner(System.in);
		
		app.play(scanner);
	}

	private void play(Scanner scanner) {
		initialDeal();

	}

	private void initialDeal() {
		System.out.println("*** Dealer deals initial cards ***");
		playerHand.addCard(dealer.dealCard());
		dealerHand.addCard(dealer.dealCard());	
		playerHand.addCard(dealer.dealCard());
		dealerHand.addCard(dealer.dealCard());	
		
		dealerHand.showDealerHand();
		System.out.println("Total points: " + dealerHand.getHandValueHideFirstIndex()+"\n");
		
		playerHand.showPlayerHand();
		System.out.println("Total points: " + playerHand.getHandValue()+"\n");
	}

}
