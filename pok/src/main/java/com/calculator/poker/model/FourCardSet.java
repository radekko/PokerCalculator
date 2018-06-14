package com.calculator.poker.model;

public class FourCardSet extends ThreeCardSet{
	
	private Card fourthCard;
	
	public FourCardSet(Card firstCard, Card secondCard, Card thirdCard, Card fourthCard) {
		super(firstCard, secondCard, thirdCard);
		this.fourthCard = fourthCard;
	}

	public Card getFourthCard() {
		return fourthCard;
	}

	public void setFourthCard(Card fourthCard) {
		this.fourthCard = fourthCard;
	}
}
