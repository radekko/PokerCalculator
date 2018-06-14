package com.calculator.poker;

import java.util.List;

import com.calculator.poker.model.Holding;
import com.calculator.poker.model.FiveCardsSet;
import com.calculator.poker.model.WinningProbability;

public class WinningProbabilityCreator {

	private Holding holding;
	private Holding holding2;
	private WinningProbability result;

	public WinningProbabilityCreator(Holding holding, Holding holding2, ListOfPossibleCardsOnTable lop) {
		this.holding = holding;
		this.holding2 = holding2;
		this.result = new WinningProbability();
		prepareStats(lop);
	}

	public void printResult() {
		System.out.println(result);
	}

	private void prepareStats(ListOfPossibleCardsOnTable lop) {
		List<FiveCardsSet> cardsOnTable = lop.getPossibleSetupOnTableWithExcludingHolecards(holding, holding2);
		for (FiveCardsSet fiveCardsSet : cardsOnTable)
			fillResultForFiveCardSet(fiveCardsSet);
	}

	private void fillResultForFiveCardSet(FiveCardsSet fiveCards) {
		WinningPlayerChecker wc = new WinningPlayerChecker(holding,holding2,fiveCards);
		if(wc.isDraw())
			result.incrementNumberOfDraws();
		else if(wc.isFirstPlayerWinner())
			result.incrementNumberOfFirstWin();
		else
			result.incrementNumberOfSecondWin();
	}
	
}
