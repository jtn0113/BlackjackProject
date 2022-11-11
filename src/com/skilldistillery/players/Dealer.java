package com.skilldistillery.players;

import com.skilldistillery.cardgame.Hand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player{
	private Deck deck;

	public Dealer(Deck deck, Hand hand) {
		super(hand);
		this.deck = deck;
	}

	public Card dealCard() {
		Card card = deck.dealCard();
		
		return card;
	}
}
