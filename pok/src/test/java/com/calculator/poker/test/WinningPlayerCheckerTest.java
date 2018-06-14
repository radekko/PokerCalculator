package com.calculator.poker.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.calculator.poker.WinningPlayerChecker;
import com.calculator.poker.model.Card;
import com.calculator.poker.model.CardColor;
import com.calculator.poker.model.CardFigure;
import com.calculator.poker.model.FiveCardsSet;
import com.calculator.poker.model.Holding;

public class WinningPlayerCheckerTest {

	private Holding firstHolding;
	private Holding secondHolding;
	private FiveCardsSet riverToCheck;
	
	@Test
	public void testTwoStraightFlush() {
		firstHolding = new Holding(new Card(CardFigure.ACE,CardColor.HEART),new Card(CardFigure.THREE,CardColor.CLUB));
		secondHolding = new Holding(new Card(CardFigure.ACE,CardColor.DIAMOND),new Card(CardFigure.EIGHT,CardColor.CLUB));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.FIVE,CardColor.CLUB),
				new Card(CardFigure.SIX,CardColor.CLUB),
				new Card(CardFigure.SEVEN,CardColor.CLUB),
				new Card(CardFigure.ACE,CardColor.CLUB));
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, false);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, true);
	}
	
	@Test
	public void testTwo4OfAKind() {
		firstHolding = new Holding(new Card(CardFigure.FOUR,CardColor.HEART),new Card(CardFigure.THREE,CardColor.CLUB));
		secondHolding = new Holding(new Card(CardFigure.SEVEN,CardColor.DIAMOND),new Card(CardFigure.SEVEN,CardColor.CLUB));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.SEVEN,CardColor.CLUB),
				new Card(CardFigure.SEVEN,CardColor.CLUB));
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, false);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, true);
	}

	@Test
	public void testTwoFull() {
		firstHolding = new Holding(new Card(CardFigure.TWO,CardColor.HEART),new Card(CardFigure.THREE,CardColor.CLUB));
		secondHolding = new Holding(new Card(CardFigure.FOUR,CardColor.DIAMOND),new Card(CardFigure.SEVEN,CardColor.CLUB));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.SEVEN,CardColor.SPADE),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.THREE,CardColor.SPADE),
				new Card(CardFigure.THREE,CardColor.SPADE)
				);
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, false);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, true);
	}
	
	@Test
	public void testTwoFlush() {
		firstHolding = new Holding(new Card(CardFigure.TWO,CardColor.CLUB),new Card(CardFigure.KING,CardColor.CLUB));
		secondHolding = new Holding(new Card(CardFigure.EIGHT,CardColor.CLUB),new Card(CardFigure.QUEEN,CardColor.CLUB));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.SEVEN,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.FIVE,CardColor.CLUB),
				new Card(CardFigure.THREE,CardColor.SPADE),
				new Card(CardFigure.JACK,CardColor.SPADE)
				);
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, true);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, false);
	}

	@Test
	public void testTwoStraight() {
		firstHolding = new Holding(new Card(CardFigure.SIX,CardColor.DIAMOND),new Card(CardFigure.KING,CardColor.DIAMOND));
		secondHolding = new Holding(new Card(CardFigure.ACE,CardColor.DIAMOND),new Card(CardFigure.QUEEN,CardColor.DIAMOND));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.TWO,CardColor.DIAMOND),
				new Card(CardFigure.THREE,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.FIVE,CardColor.SPADE),
				new Card(CardFigure.JACK,CardColor.SPADE)
				);
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, true);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, false);
	}
	
	@Test
	public void testTwoThreeOfAKind() {
		firstHolding = new Holding(new Card(CardFigure.TWO,CardColor.DIAMOND),new Card(CardFigure.TWO,CardColor.DIAMOND));
		secondHolding = new Holding(new Card(CardFigure.TEN,CardColor.DIAMOND),new Card(CardFigure.TEN,CardColor.DIAMOND));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.TWO,CardColor.DIAMOND),
				new Card(CardFigure.SIX,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.TEN,CardColor.SPADE),
				new Card(CardFigure.JACK,CardColor.SPADE)
				);
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, false);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, true);
	}
	
	@Test
	public void testTwoTwoPair() {
		firstHolding = new Holding(new Card(CardFigure.TWO,CardColor.DIAMOND),new Card(CardFigure.JACK,CardColor.DIAMOND));
		secondHolding = new Holding(new Card(CardFigure.FOUR,CardColor.DIAMOND),new Card(CardFigure.JACK,CardColor.DIAMOND));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.TWO,CardColor.DIAMOND),
				new Card(CardFigure.SIX,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.TEN,CardColor.SPADE),
				new Card(CardFigure.JACK,CardColor.SPADE)
				);
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, false);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, true);
	}
	
	@Test
	public void testTwoPairs() {
		firstHolding = new Holding(new Card(CardFigure.TWO,CardColor.DIAMOND),new Card(CardFigure.QUEEN,CardColor.DIAMOND));
		secondHolding = new Holding(new Card(CardFigure.FOUR,CardColor.DIAMOND),new Card(CardFigure.KING,CardColor.DIAMOND));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.TWO,CardColor.DIAMOND),
				new Card(CardFigure.SIX,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.TEN,CardColor.SPADE),
				new Card(CardFigure.JACK,CardColor.SPADE)
				);
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, false);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, true);
	}
	
	@Test
	public void testTwoHighCard() {
		firstHolding = new Holding(new Card(CardFigure.EIGHT,CardColor.DIAMOND),new Card(CardFigure.QUEEN,CardColor.DIAMOND));
		secondHolding = new Holding(new Card(CardFigure.NINE,CardColor.DIAMOND),new Card(CardFigure.KING,CardColor.DIAMOND));
		riverToCheck = new FiveCardsSet(
				new Card(CardFigure.TWO,CardColor.DIAMOND),
				new Card(CardFigure.SIX,CardColor.CLUB),
				new Card(CardFigure.FOUR,CardColor.CLUB),
				new Card(CardFigure.TEN,CardColor.SPADE),
				new Card(CardFigure.JACK,CardColor.SPADE)
				);
		
		testIfDraw(firstHolding, secondHolding, riverToCheck, false);
		testIfFirstWin(firstHolding, secondHolding, riverToCheck, false);
		testIfSecondWin(firstHolding, secondHolding, riverToCheck, true);
	}
	
	private void testIfDraw(Holding firstHolding, Holding secondHolding, FiveCardsSet river, boolean expected) {
		WinningPlayerChecker sr = new WinningPlayerChecker(firstHolding, secondHolding,river);
		assertEquals(sr.isDraw(),expected);
	}
	
	private void testIfFirstWin(Holding firstHolding, Holding secondHolding, FiveCardsSet river, boolean expected) {
		WinningPlayerChecker sr = new WinningPlayerChecker(firstHolding, secondHolding,river);
		assertEquals(sr.isFirstPlayerWinner(),expected);
	}
	private void testIfSecondWin(Holding firstHolding, Holding secondHolding, FiveCardsSet river, boolean expected) {
		WinningPlayerChecker sr = new WinningPlayerChecker(firstHolding, secondHolding,river);
		assertEquals(sr.isSecondPlayerWinner(),expected);
	}
	
}
