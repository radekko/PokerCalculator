package com.calculator.poker;

import java.util.ArrayList;
import java.util.List;

import com.calculator.poker.generators.CombinationGenerator;
import com.calculator.poker.generators.DeckCreator;
import com.calculator.poker.model.Card;
import com.calculator.poker.model.Holding;
import com.calculator.poker.model.FiveCardsSet;

public class ListOfPossibleCardsOnTable {
	
	private List<Card> possibleCardsWhichMayBeUsingToPrepareFiveCardsSet;
	
	public ListOfPossibleCardsOnTable() {
		possibleCardsWhichMayBeUsingToPrepareFiveCardsSet = DeckCreator.createDeck();
	}
	
	public List<FiveCardsSet> getPossibleSetupOnTableWithExcludingHolecards(Holding... holdingToExclude) {
		removeHoldingsFromListOfPossibleCards(holdingToExclude);
		return createListOfPossiblesTableCombo();
	}
	
	private void removeHoldingsFromListOfPossibleCards(Holding... holdingToExclude) {
		List<Card> holdingsToRemove = extractCardsFromHoldingToRemove(holdingToExclude);
		possibleCardsWhichMayBeUsingToPrepareFiveCardsSet.removeAll(holdingsToRemove);
	}

	private List<FiveCardsSet> createListOfPossiblesTableCombo() {
		List<FiveCardsSet> listOfPossibleTableCombos = new ArrayList<FiveCardsSet>();
		List<List<Card>> allPossibleCombinationsOf5Card = combineRestCards();
		for(List<Card> combo : allPossibleCombinationsOf5Card) 
			listOfPossibleTableCombos.add(createOneTableCombo(combo));

		return new ArrayList<>(listOfPossibleTableCombos);
	}

	private List<List<Card>> combineRestCards() {
		return CombinationGenerator
				.getCombinations(5, possibleCardsWhichMayBeUsingToPrepareFiveCardsSet);
	}
	
	private List<Card> extractCardsFromHoldingToRemove(Holding... holding) {
		List<Card> cardsToRemove = new ArrayList<Card>();
		for (Holding h : holding)
			addExtractedCards(cardsToRemove, h);
		
		return cardsToRemove;
	}

	private void addExtractedCards(List<Card> holdings, Holding t) {
		holdings.add(t.getFirstCard());
		holdings.add(t.getSecondCard());
	}

	private FiveCardsSet createOneTableCombo(List<Card> listWithOneCombination) {
		return new FiveCardsSet(listWithOneCombination.get(0), listWithOneCombination.get(1), 
				listWithOneCombination.get(2), listWithOneCombination.get(3), listWithOneCombination.get(4));
	}

}
