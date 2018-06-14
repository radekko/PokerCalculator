package com.calculator.poker.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.calculator.poker.ListOfPossibleCardsOnTable;
import com.calculator.poker.model.Card;
import com.calculator.poker.model.CardColor;
import com.calculator.poker.model.CardFigure;
import com.calculator.poker.model.FiveCardsSet;
import com.calculator.poker.model.Holding;

public class ListOfPossibleCardsOnTableTest {

	@Test
	public void testSizeOfListWhenRemoveTwoHolecards() {
		ListOfPossibleCardsOnTable l = new ListOfPossibleCardsOnTable();
		Holding firstHolding = new Holding(
				new Card(CardFigure.ACE,CardColor.HEART),new Card(CardFigure.THREE,CardColor.CLUB));
		Holding secondHolding = new Holding(
				new Card(CardFigure.ACE,CardColor.DIAMOND),new Card(CardFigure.EIGHT,CardColor.CLUB));
		List<FiveCardsSet>  list = l.getPossibleSetupOnTableWithExcludingHolecards(firstHolding,secondHolding);
		assertEquals(1712304,list.size());
	}
	
	@Test
	public void testSizeOfListWhenNotRemoveAnyoHolecards() {
		ListOfPossibleCardsOnTable l = new ListOfPossibleCardsOnTable();
		List<FiveCardsSet>  list = l.getPossibleSetupOnTableWithExcludingHolecards();
		assertEquals(2598960,list.size());
	}
	
}
