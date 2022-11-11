package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deckOfCards;

	public Deck() {
		deckOfCards = new ArrayList<>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				Card card = new Card(rank, suit);
				deckOfCards.add(card);
			}
		}
		shuffle();
	}
	
	public int checkDeckSize() {
		return deckOfCards.size();
	}
	
	public Card dealCard() {
		return deckOfCards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}
	
}
