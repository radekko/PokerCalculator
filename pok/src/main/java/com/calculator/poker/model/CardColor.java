package com.calculator.poker.model;

public enum CardColor {
	HEART(1,'h'), 
	DIAMOND(2,'d'), 
	SPADE(3,'s'),
	CLUB(4,'c');
	
	private int value;
	private char sign;

	private CardColor(int value, char sign) {
		this.value = value;
		this.sign = sign;
	}

	public int getValue() {
		return value;
	}

	public char getSign() {
		return sign;
	}
	
}
