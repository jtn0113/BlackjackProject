package com.skilldistillery.cardgame;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand{

	public BlackjackHand() {
		
	}

	@Override
	public int getHandValue() {
		int cardValue = 0;
		for (Card card : cards) {
			cardValue += card.getValue();
		}
		return cardValue;
	}
	
	public int getHandValueHideFirstIndex() {
		int cardValue = 0;
		if (!cards.isEmpty()) {
			cardValue = getHandValue() - cards.get(0).getValue();
		}
		return cardValue;
	}
	
	public boolean isBlackJack() {
		boolean isBlackJack;
		if (cards.get(0).getValue() + cards.get(1).getValue() == 21) {
			isBlackJack = true;
		} else {
			isBlackJack = false;
		}
		return isBlackJack;
	}
	
	public boolean isBust() {
		boolean isBust;
		int handTotal = 0;
		
		for (Card card : cards) {
			handTotal += card.getValue();
		}
		
		if (handTotal > 21) {
			isBust = true;
		} else {
			isBust = false;
		}
		
		return isBust;
	}
	
	public void showPlayerHand() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
	
	public void showDealerHand() {
		System.out.println("FACE DOWN CARD");
		for (int i=1; i<cards.size(); i++) {
			System.out.println(cards.get(i));
		}
	}
	
	
}
