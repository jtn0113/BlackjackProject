package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.cards.Deck;
import com.skilldistillery.players.Dealer;
import com.skilldistillery.players.Player;

public class BlackJackApp {
	private Dealer dealer = new Dealer();
	private Player player = new Player();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		Scanner scanner = new Scanner(System.in);

		app.initialDeal(scanner);
	}

	private void initialDeal(Scanner scanner) {
		if(dealer.getDeck().checkDeckSize() < 15) {
			dealer.setDeck(new Deck());
		}
		System.out.println("*** Dealer deals initial cards ***");
		player.getHand().addCard(dealer.dealCard());
		dealer.getHand().addCard(dealer.dealCard());
		player.getHand().addCard(dealer.dealCard());
		dealer.getHand().addCard(dealer.dealCard());

		displayDealerHandHideFirst();

		displayPlayerHand();

		if (player.getHand().isBlackJack()) {
			System.out.println("You hit Blackjack!");
			winOrLose(scanner);
		} else if (player.getHand().isBust()) {
			System.out.println("You bust. Dealer wins.");
		} else {
			hitMe(scanner);
		}
	}

	private void winOrLose(Scanner scanner) {
		int playerScore = player.getHand().getHandValue();
		int dealerScore = dealer.getHand().getHandValueHideFirstIndex();
		if (playerScore > 21) {
			System.out.println("You bust. Dealer wins.");
		} else if (dealerScore > 21) {
			System.out.println("Dealer busts. You win.");
		} else {
			dealerScore = dealer.getHand().getHandValue();
			System.out.println("Dealer flips card");
			displayDealerHand();
			if(dealerScore > 21) {
				System.out.println("Dealer busts. You win.");
			} else {
				dealerScore = dealerPlays();
				if (playerScore > dealerScore) {
					System.out.println("You win!");
				} else if (dealerScore > 21) {
					System.out.println("Dealer busts. You win.");
				} else if (dealerScore > playerScore) {
					System.out.println("Dealer Wins");
				} else {
					System.out.println("It's a push");
				}
			}
		}
		System.out.println();
		System.out.println("SELECT\n1.)Play Again\n2.)Done");
		if(scanner.nextInt() == 1) {
			player.getHand().emptyHand();
			dealer.getHand().emptyHand();
			initialDeal(scanner);
		} else {
			System.out.println("Thanks for playing");
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
		while (!stand) {
			switch (hitOrStand(scanner)) {
			case "1":
				player.getHand().addCard(dealer.dealCard());
				displayPlayerHand();
				if (player.getHand().isBust()) {
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
		winOrLose(scanner);
	}

	private void displayPlayerHand() {
		System.out.println("Your Hand:");
		player.getHand().showPlayerHand();
		System.out.println("Total points: " + player.getHand().getHandValue() + "\n");
	}

	private void displayDealerHand() {
		System.out.println("Dealer Hand:");
		dealer.getHand().showPlayerHand();
		System.out.println("Total points: " + dealer.getHand().getHandValue() + "\n");
	}

	private void displayDealerHandHideFirst() {
		System.out.println("Dealer Hand:");
		dealer.getHand().showDealerHand();
		System.out.println("Total points: " + dealer.getHand().getHandValueHideFirstIndex() + "\n");
	}

	private int dealerPlays() {
		int dealerScore = dealer.getHand().getHandValue();
		while (dealerScore < 17) {
			dealer.getHand().addCard(dealer.dealCard());
			dealerScore = dealer.getHand().getHandValue();
			displayDealerHand();
		}

		return dealerScore;
	}

}
