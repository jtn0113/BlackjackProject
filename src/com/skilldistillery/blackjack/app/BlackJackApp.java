package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp {
	private Dealer dealer = new Dealer();
	private Player player = new Player();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		Scanner scanner = new Scanner(System.in);
		
		app.play(scanner);
	}

	private void play(Scanner scanner) {
		initialDeal(scanner);

	}

	private void initialDeal(Scanner scanner) {
		System.out.println("*** Dealer deals initial cards ***");
		player.getHand().addCard(dealer.dealCard());
		dealer.getHand().addCard(dealer.dealCard());	
		player.getHand().addCard(dealer.dealCard());
		dealer.getHand().addCard(dealer.dealCard());	
		
		displayDealerHandHideFirst();
		
		displayPlayerHand();
		
		if(player.getHand().isBlackJack()) {
			System.out.println("You hit Blackjack!");
			winOrLose();
		} else if(player.getHand().isBust()) {
			System.out.println("You bust. Dealer wins.");
		} else {
			hitMe(scanner);
		}
	}

	private void winOrLose() {
		int playerScore = player.getHand().getHandValue();
		int dealerScore = dealer.getHand().getHandValue();
		if(playerScore > 21) {
			System.out.println("You bust. Dealer wins.");
		} else {
			System.out.println("Dealer flips card");
			System.out.println("Dealer Hand:");
			dealer.getHand().showPlayerHand();
			System.out.println("Total points: " + dealerScore+"\n");
			if(playerScore > dealerScore) {
				System.out.println("You win!");
			} else if(dealerScore > playerScore) {
				System.out.println("Dealer Wins");
			} else {
				System.out.println("It's a push");
			}
		}
	}
	
	private String hitOrStand(Scanner scanner) {
		System.out.println("SELECT\n1.)Hit\n2.)Stand");
		String selection = scanner.next();
		scanner.nextLine();
		return selection;
	}
	
	private void hitMe(Scanner scanner) {
		boolean stand = false;
		while(!stand) {
			switch (hitOrStand(scanner)) {
			case "1":
				player.getHand().addCard(dealer.dealCard());
				displayPlayerHand();
				if(player.getHand().isBust()) {
					stand = true;
				}
				break;
			case "2":
				stand = true;
				break;
			default:
				break;
			}
		}
		winOrLose();
	}
	
	private void displayPlayerHand() {
		System.out.println("Your Hand:");
		player.getHand().showPlayerHand();
		System.out.println("Total points: " + player.getHand().getHandValue()+"\n");
	}
	
	private void displayDealerHand() {
		System.out.println("Dealer Hand:");
		dealer.getHand().showPlayerHand();
		System.out.println("Total points: " + dealer.getHand().getHandValue()+"\n");
	}
	
	private void displayDealerHandHideFirst() {
		System.out.println("Dealer Hand:");
		dealer.getHand().showDealerHand();
		System.out.println("Total points: " + dealer.getHand().getHandValueHideFirstIndex()+"\n");
	}

}
