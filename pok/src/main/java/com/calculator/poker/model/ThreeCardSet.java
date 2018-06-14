package com.calculator.poker.model;

public class ThreeCardSet {
	private Card firstCard;
	private Card secondCard;
	private Card thirdCard;
	
	public ThreeCardSet(Card firstCard, Card secondCard, Card thirdCard) {
		this.firstCard = firstCard;
		this.secondCard = secondCard;
		this.thirdCard = thirdCard;
	}
	public Card getFirstCard() {
		return firstCard;
	}
	public void setFirstCard(Card firstCard) {
		this.firstCard = firstCard;
	}
	public Card getSecondCard() {
		return secondCard;
	}
	public void setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
	}
	public Card getThirdCard() {
		return thirdCard;
	}
	public void setThirdCard(Card thirdCard) {
		this.thirdCard = thirdCard;
	}
	
	
}
