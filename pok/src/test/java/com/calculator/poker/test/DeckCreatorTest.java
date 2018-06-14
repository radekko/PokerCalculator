package com.calculator.poker.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.calculator.poker.generators.DeckCreator;
import com.calculator.poker.model.Card;

public class DeckCreatorTest {

	@Test
	public void testIfcreatedDeckHasValidAmountOfCards() {
		List<Card> deck = DeckCreator.createDeck();
		assertEquals(deck.size(),52);
	}
}
