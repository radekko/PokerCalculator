package com.calculator.poker.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.calculator.poker.TheHighestSetupChecker;
import com.calculator.poker.model.Card;
import com.calculator.poker.model.CardColor;
import com.calculator.poker.model.CardFigure;
import com.calculator.poker.model.Setup;
import com.calculator.poker.model.ShowdownResult;

public class TheHighestSetupCheckerTest {
	
	@Test
	public void testIfStraightFlush() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.TWO, CardColor.CLUB));
			add(new Card(CardFigure.THREE, CardColor.CLUB));
			add(new Card(CardFigure.FOUR, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.CLUB));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.STRAIGHT_FLUSH, listWith7CardToCheck);
	}

	@Test
	public void testIf4OfAKing() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.CLUB));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.FOUR_OF_A_KIND, listWith7CardToCheck);
	}
	
	@Test
	public void testIfFull() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.CLUB));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.FULL_HOUSE, listWith7CardToCheck);
	}
	
	@Test
	public void testIfFlush() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.TWO, CardColor.CLUB));
			add(new Card(CardFigure.THREE, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.HEART));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.FLUSH, listWith7CardToCheck);
	}
	
	@Test
	public void testIfStraight() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.TWO, CardColor.CLUB));
			add(new Card(CardFigure.THREE, CardColor.DIAMOND));
			add(new Card(CardFigure.FOUR, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.HEART));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.STRAIGH, listWith7CardToCheck);
	}
	

	@Test
	public void testIfThreeOfAKind() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.DIAMOND));
			add(new Card(CardFigure.FOUR, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.HEART));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.THREE_OF_A_KIND, listWith7CardToCheck);
	}
	
	@Test
	public void testIfTwoPair() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.FOUR, CardColor.DIAMOND));
			add(new Card(CardFigure.FOUR, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.HEART));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.TWO_PAIR, listWith7CardToCheck);
	}
	
	@Test
	public void testIfPair() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.TWO, CardColor.DIAMOND));
			add(new Card(CardFigure.FOUR, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.HEART));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.PAIR, listWith7CardToCheck);
	}
	
	@Test
	public void testIfHighCard() {
		@SuppressWarnings("serial")
		List<Card> listWith7CardToCheck = new ArrayList<Card>() {{
			add(new Card(CardFigure.ACE, CardColor.CLUB));
			add(new Card(CardFigure.TWO, CardColor.CLUB));
			add(new Card(CardFigure.JACK, CardColor.DIAMOND));
			add(new Card(CardFigure.FOUR, CardColor.CLUB));
			add(new Card(CardFigure.FIVE, CardColor.HEART));
			add(new Card(CardFigure.NINE, CardColor.DIAMOND));
			add(new Card(CardFigure.TEN, CardColor.CLUB));
		}};
		compareShowdownResultWithExpected(ShowdownResult.HIGH_CARD, listWith7CardToCheck);
	}
	
	private void compareShowdownResultWithExpected(ShowdownResult expected, List<Card> listWith7CardToCheck) {
		TheHighestSetupChecker sc = new TheHighestSetupChecker(listWith7CardToCheck);
		Setup winning2 = sc.getTheHighestSetup();
		assertEquals(expected, winning2.getShowdownResult());
	}
	
}
