package com.skilldistillery.players;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player{
	private Deck deck;

	public Dealer() {
		super();
		this.deck = new Deck();
	}

	public Card dealCard() {
		Card card = deck.dealCard();
		
		return card;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
}
