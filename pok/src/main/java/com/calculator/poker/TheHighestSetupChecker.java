package com.calculator.poker;

import java.util.List;
import java.util.stream.IntStream;

import com.calculator.poker.generators.CombinationGenerator;
import com.calculator.poker.model.Card;
import com.calculator.poker.model.CardColor;
import com.calculator.poker.model.ShowdownResult;
import com.calculator.poker.model.Setup;

public class TheHighestSetupChecker {

	private List<List<Card>> allPosibleShowdownCombinationsToCheck;

	public TheHighestSetupChecker(List<Card> listWith7CardToCheck) {
		this.allPosibleShowdownCombinationsToCheck =
				CombinationGenerator.getCombinations(5, listWith7CardToCheck);
	}

	public Setup getTheHighestSetup() {
		return extractTheHighestShowdownSetup();
	}

	private Setup extractTheHighestShowdownSetup() {
		Setup currentWinningSetup = null;
		for(List<Card> oneShowdownCombo : allPosibleShowdownCombinationsToCheck) {
			Setup nextSetup = convertOnePossibleCardCombinationToSetup(oneShowdownCombo);
			currentWinningSetup = pointHighest(currentWinningSetup, nextSetup);
		}
		return currentWinningSetup;
	}

	private Setup pointHighest(Setup winningSetup, Setup wr) {
		if(winningSetup == null)
			winningSetup = wr;
		else
			winningSetup = SetupComparator.pointWinningSetup(wr, winningSetup);
		return winningSetup;
	}
	
	private Setup convertOnePossibleCardCombinationToSetup(List<Card> oneShowdownCombo) {
		boolean isFlush = checkIfFlush(oneShowdownCombo);
		int[] rank = convertCardListToRankTable(oneShowdownCombo);
		
		if (isFlush && checkIfIsStraight(rank))
			return new Setup(ShowdownResult.STRAIGHT_FLUSH,rank);
		if (checkIfTheSame(rank, 4))
			return new Setup(ShowdownResult.FOUR_OF_A_KIND,rank);
		if (checkIfFullHouse(rank))
			return new Setup(ShowdownResult.FULL_HOUSE,rank);
		if (isFlush)
			return new Setup(ShowdownResult.FLUSH,rank);
		if (checkIfIsStraight(rank))
			return new Setup(ShowdownResult.STRAIGH,rank);
		if (checkIfTheSame(rank, 3))
			return new Setup(ShowdownResult.THREE_OF_A_KIND,rank);
		if (checkIf2Pair(rank))
			return new Setup(ShowdownResult.TWO_PAIR,rank);
		if (checkIfTheSame(rank, 2))
			return new Setup(ShowdownResult.PAIR,rank);
		return new Setup(ShowdownResult.HIGH_CARD,rank);
	}

	private int[] convertCardListToRankTable(List<Card> onePossibility) {
		int[] rank = new int[13];
	
		for (Card c : onePossibility) {
			int index = c.getFigure().getValue() - 2;
			int temp = rank[index];
			rank[index] = ++temp;
		}
		return rank;
	}

	private boolean checkIfIsStraight(int[] rank) {
		int firstNotNullIndex = 
				IntStream.range(0, rank.length).filter(i -> rank[i] != 0).findFirst().orElse(-1);

		if (firstNotNullIndex == 0 && checkIf5HighStraight(rank) == true)
			return true;

		for (int i = firstNotNullIndex; i < firstNotNullIndex + 5; i++) {
			if (rank[i] != 1) 
				return false;
		}
		return true;
	}

	private boolean checkIf5HighStraight(int[] rank) {
		for (int i = 0; i < 4; i++) {
			if (rank[i] != 1) 
				return false;
		}
		if(rank[12] == 1)
			return true;
			
		return false;
	}

	private boolean checkIfFullHouse(int[] rank) {
		boolean flag3 = false;
		boolean flag2 = false;

		for (int i = 0; i < rank.length; i++) {
			if (rank[i] == 3)
				flag3 = true;
			else if (rank[i] == 2)
				flag2 = true;

			if (flag3 && flag2)
				return true;
		}
		return false;
	}

	private boolean checkIfTheSame(int[] rank, int amountOfTheSame) {
		for (int i = 0; i < rank.length; i++) {
			if (rank[i] == amountOfTheSame)
				return true;
		}
		return false;
	}

	private boolean checkIf2Pair(int[] rank) {
		boolean flag = false;
		for (int i = 0; i < rank.length; i++) {
			if (rank[i] == 2 && flag)
				return true;
			else if (rank[i] == 2)
				flag = true;
		}
		return false;
	}

	private boolean checkIfFlush(List<Card> onePossibility) {
		CardColor possibleColor = onePossibility.get(0).getColor();

		for (int i = 1; i < 5; i++) {
			if (possibleColor != onePossibility.get(i).getColor())
				return false;
		}
		return true;
	}
}
