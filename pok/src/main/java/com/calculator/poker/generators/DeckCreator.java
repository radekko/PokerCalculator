package com.calculator.poker.generators;

import java.util.ArrayList;
import java.util.List;

import com.calculator.poker.model.Card;
import com.calculator.poker.model.CardColor;
import com.calculator.poker.model.CardFigure;

public class DeckCreator {

	public static List<Card> createDeck() {
		List<Card> deck = new ArrayList<Card>();

		for (CardColor color : CardColor.values()) 
			addCardsInOneColor(deck, color);
		
		return deck;
	}

	private static void addCardsInOneColor(List<Card> deck, CardColor color) {
		for (CardFigure figure : CardFigure.values()) 
			deck.add(createCard(color, figure));
	}

	private static Card createCard(CardColor color, CardFigure figure) {
		return new Card(figure, color);
	}
}
