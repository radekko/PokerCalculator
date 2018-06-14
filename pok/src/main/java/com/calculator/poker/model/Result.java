package com.calculator.poker.model;

public class Result {
	
	private static int amountOfStraightFlush = 0;
	private static int amountOfQuads = 0;
	private static int amountOfFulls = 0;
	private static int amountOfFlushes = 0;
	private static int amountOfStraights = 0;
	private static int amountOfThrees = 0;
	private static int amountOfTwoPairs = 0;
	private static int amountOfPairs = 0;
	private static int amountOfHighCard = 0;
	
	public int getTotal() {
		return amountOfStraightFlush + amountOfQuads + amountOfFulls + amountOfFlushes +
				amountOfStraights + amountOfThrees + amountOfTwoPairs + amountOfPairs + amountOfHighCard;
	}
	public int getAmountOfStraightFlush() {
		return amountOfStraightFlush;
	}
	public void setAmountOfStraightFlush() {
		amountOfStraightFlush++;
	}
	public int getAmountOfQuads() {
		return amountOfQuads;
	}
	public void setAmountOfQuads() {
		amountOfQuads++;
	}
	public int getAmountOfFulls() {
		return amountOfFulls;
	}
	public void setAmountOfFulls() {
		amountOfFulls++;
	}
	public int getAmountOfFlushes() {
		return amountOfFlushes;
	}
	public void setAmountOfFlushes() {
		amountOfFlushes++;
	}
	public int getAmountOfStraights() {
		return amountOfStraights;
	}
	public void setAmountOfStraights() {
		amountOfStraights++;
	}
	public int getAmountOfThrees() {
		return amountOfThrees;
	}
	public void setAmountOfThrees() {
		amountOfThrees++;
	}
	public int getAmountOfTwoPairs() {
		return amountOfTwoPairs;
	}
	public void setAmountOfTwoPairs() {
		amountOfTwoPairs++;
	}
	public int getAmountOfPairs() {
		return amountOfPairs;
	}
	public void setAmountOfPairs() {
		amountOfPairs++;
	}
	public int getAmountOfHighCard() {
		return amountOfHighCard;
	}
	public void setAmountOfHighCard() {
		amountOfHighCard++;
	}
	@Override
	public String toString() {
		return "STRAIGHT FLUSH =" + getAmountOfStraightFlush() + "\nQUADS ="
				+ getAmountOfQuads() + "\nFULLS=" + getAmountOfFulls() + "\nFLUSHES="
				+ getAmountOfFlushes() + "\nSTRAIGHTS=" + getAmountOfStraights() + "\nTHREE ="
				+ getAmountOfThrees() + "\nTWO PAIR=" + getAmountOfTwoPairs() + "\nPAIR ="
				+ getAmountOfPairs() + "\nHIGH CARD=" + getAmountOfHighCard();
	}
	
	
}
