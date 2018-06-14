package com.calculator.poker.model;

public class FiveCardsSet extends FourCardSet {

	private Card fifthCard;
	
	public FiveCardsSet(Card firstCard, Card secondCard, Card thirdCard, Card fourthCard, Card fifthCard) {
		super(firstCard, secondCard, thirdCard, fourthCard);
		this.fifthCard = fifthCard;
	}

	public Card getFifthCard() {
		return fifthCard;
	}

	public void setFifthCard(Card fifthCard) {
		this.fifthCard = fifthCard;
	}

	@Override
	public String toString() {
		return fifthCard + " " + getFourthCard() + " " + getThirdCard() + " " + getSecondCard() + " " + getFirstCard() + " ";
	}
	
}
