package com.calculator.poker;

import com.calculator.poker.model.Setup;
import com.calculator.poker.model.ShowdownResult;
import com.calculator.poker.model.Winner;

public class SetupComparator {
	
	public static Winner pointWinner(Setup wr, Setup wr2) {
		Setup winner = pointWinningSetup(wr, wr2);
		if(winner.equals(wr))
			return Winner.FIRST;
		else
			return Winner.SECOND;
	}
	
	public static Setup pointWinningSetup(Setup wr, Setup wr2) {
		if (isFirstSetupWinning(wr, wr2))
			return wr;
		if (isSecondSetupWinning(wr, wr2))
			return wr2;
		else 
			return 
				isFirstSetupWinningWhenTheSameKind(wr.getShowdownResult(), wr.getRank(), wr2.getRank()) ? wr : wr2;
	}

	private static boolean isSecondSetupWinning(Setup wr, Setup wr2) {
		return wr.getShowdownResult().ordinal() > wr2.getShowdownResult().ordinal();
	}

	private static boolean isFirstSetupWinning(Setup wr, Setup wr2) {
		return wr.getShowdownResult().ordinal() < wr2.getShowdownResult().ordinal();
	}

	private static boolean isFirstSetupWinningWhenTheSameKind(ShowdownResult shResult, int[] rank, int[] rank2) {
		switch (shResult) {
			case STRAIGHT_FLUSH:
				return compareStraightFlushes(rank, rank2);
			case FOUR_OF_A_KIND:
				return compareFourOfAKind(rank, rank2);
			case FULL_HOUSE:
				return compareFullHouses(rank, rank2);
			case FLUSH:
				return compareFlushes(rank, rank2);
			case STRAIGH:
				return compareStraights(rank, rank2);
			case THREE_OF_A_KIND:
				return compareThreeOfAKind(rank, rank2);
			case TWO_PAIR:
				return compareTwoPair(rank, rank2);
			case PAIR:
				return comparePairs(rank, rank2);
			case HIGH_CARD:
				return compareHighCards(rank, rank2);
		}
		return false;
	}

	private static boolean compareStraightFlushes(int[] rank, int[] rank2) {
		return compareStraights(rank, rank2);
	}

	private static boolean compareFourOfAKind(int[] rank, int[] rank2) {
		return compareAnyOfKind(rank, rank2, 4);
	}

	private static boolean compareFullHouses(int[] rank, int[] rank2) {
		for(int i = rank.length - 1; i >= 0; i--) {
			if(rank[i] == 0 && rank2[i] == 0)
				continue;
			else if(rank[i] == 3 && rank2[i] != 3)
				return true;
			else if(rank[i] != 3 && rank2[i] == 3)
				return false;
		}
		return false;
	}

	private static boolean compareFlushes(int[] rank, int[] rank2) {
		return compareAllRankWithExcludedIndex(rank, rank2, -1, -1);
	}

	private static boolean compareStraights(int[] rank, int[] rank2) {
		if(rank[12] == 1 && rank[11] == 0)
			return false;
		if(rank2[12] == 1 && rank2[11] == 0)
			return true;
			
		for(int i = 0; i < rank.length; i++) {
			
			if(rank[i] == 1)
				return false;
			if(rank2[i] == 1)
				return true;
		}
		return false;
	}

	private static boolean compareThreeOfAKind(int[] rank, int[] rank2) {
		return compareAnyOfKind(rank, rank2, 3);
	}

	private static boolean compareTwoPair(int[] rank, int[] rank2) {
		int c = -1;
		int c2 = -1;
		for(int i = rank.length - 1; i >= 0; i--) {
			if(rank[i] == 0 && rank2[i] == 0)
				continue;
			else if(rank[i] == 2 && rank2[i] != 2)
				return true;
			else if(rank[i] != 2 && rank2[i] == 2)
				return false;
			else if(rank[i] == 2 && rank2[i] == 2)
			{
				if(c == 0)
					c = i;
				else
					c2 = i;
			}
		}
		return compareAllRankWithExcludedIndex(rank, rank2, c, c2);
	}

	private static boolean comparePairs(int[] rank, int[] rank2) {
		return compareAnyOfKind(rank, rank2, 2);
	}

	private static boolean compareHighCards(int[] rank, int[] rank2) {
		for(int i = rank.length - 1; i >= 0; i--) {
			if(rank[i] == 0 && rank2[i] == 0)
				continue;
			else if(rank[i] == 1 && rank2[i] != 1)
				return true;
			else if(rank[i] != 1 && rank2[i] == 1)
				return false;
		}
		return false;
	}

	private static boolean compareAnyOfKind(int[] rank, int[] rank2, int flag) {
		for(int i = rank.length - 1; i >= 0; i--) {
			if(rank[i] == 0 && rank2[i] == 0)
				continue;
			else if(rank[i] == flag && rank2[i] != flag)
				return true;
			else if(rank[i] != flag && rank2[i] == flag)
				return false;
			else if(rank[i] == flag && rank2[i] == flag)
				return compareAllRankWithExcludedIndex(rank, rank2, i, -1);
		}
		return false;
	}

	private static boolean compareAllRankWithExcludedIndex(int[] rank, int[] rank2, int excluded, int secondExcluded) {
			for(int i = rank.length - 1; i >= 0; i--) {
				if(i == excluded || i == secondExcluded || (rank[i] == 0 && rank2[i] == 0))
					continue;
				else if(rank[i] == 1 && rank2[i] != 1)
					return true;
				else if(rank[i] != 1 && rank2[i] == 1)
					return false;
			}
		
		return false;
	}

}
