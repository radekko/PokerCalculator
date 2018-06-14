package com.calculator.poker.model;

public class Card {
	private CardFigure figure;
	private CardColor color;
	
	public CardFigure getFigure() {
		return figure;
	}
	public void setFigure(CardFigure firstValue) {
		this.figure = firstValue;
	}
	public CardColor getColor() {
		return color;
	}
	public void setColor(CardColor firstColor) {
		this.color = firstColor;
	}
	public Card(CardFigure firstValue, CardColor firstColor) {
		this.figure = firstValue;
		this.color = firstColor;
	}
	@Override
	public String toString() {
		return figure + " " + color;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((figure == null) ? 0 : figure.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (figure != other.figure)
			return false;
		return true;
	}
}
