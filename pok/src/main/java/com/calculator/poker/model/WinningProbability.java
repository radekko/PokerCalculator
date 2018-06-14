package com.calculator.poker.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WinningProbability {
	
	private int numberOfFirstWin = 0;
	private int numberOfSecondWin = 0;
	private int numberOfDraws = 0;
	private final static int TOTAL_RIVERS_FOR_48_CARDS = 1712304;
	
	public int getFirst() {
		return numberOfFirstWin;
	}
	public void incrementNumberOfFirstWin() {
		numberOfFirstWin++;
	}
	public int getSecond() {
		return numberOfSecondWin;
	}
	public void incrementNumberOfSecondWin() {
		numberOfSecondWin++;
	}
	public int getDraw() {
		return numberOfDraws;
	}
	public void incrementNumberOfDraws() {
		numberOfDraws++;
	}
	public int total() {
		return numberOfFirstWin + numberOfSecondWin + numberOfDraws;
	}
	@Override
	public String toString() {
		return "first %= " + computePercent(numberOfFirstWin) + "\nsecond %= " + computePercent(numberOfSecondWin) + "\ndraw %= " + computePercent(numberOfDraws) +"\ntotal= " +total();
	}
	
	private static BigDecimal computePercent(int n) {
		BigDecimal in = new BigDecimal(n);
		return in.multiply(new BigDecimal("100")).divide(new BigDecimal(TOTAL_RIVERS_FOR_48_CARDS),6, RoundingMode.HALF_UP);
	}
	
}
