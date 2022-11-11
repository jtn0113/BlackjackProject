package com.skilldistillery.players;

import com.skilldistillery.cardgame.BlackjackHand;

public class Player {
	private BlackjackHand hand;

	public Player() {
		super();
		hand = new BlackjackHand();
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}
	
	
}
