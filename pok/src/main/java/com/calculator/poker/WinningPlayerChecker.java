package com.calculator.poker;

import java.util.ArrayList;
import java.util.List;

import com.calculator.poker.model.Card;
import com.calculator.poker.model.Holding;
import com.calculator.poker.model.FiveCardsSet;
import com.calculator.poker.model.Winner;
import com.calculator.poker.model.Setup;

public class WinningPlayerChecker {

	private Winner winner;
	private List<Card> listWith7CardToCheckFirstPlayer;
	private List<Card> listWith7CardToCheckSecondPlayer;
	
	public WinningPlayerChecker(Holding firstHolding, Holding secondHolding, FiveCardsSet river) {
		this.listWith7CardToCheckFirstPlayer = prepareListOfPossibleCombos(firstHolding, river);
		this.listWith7CardToCheckSecondPlayer = prepareListOfPossibleCombos(secondHolding, river);
		calculateWinner();
	}

	public boolean isFirstPlayerWinner() {
		return winner == Winner.FIRST? true : false;
	}

	public boolean isSecondPlayerWinner() {
		return winner == Winner.SECOND? true : false;
	}

	public boolean isDraw() {
		return winner == Winner.DRAW? true : false;
	}

	private List<Card> prepareListOfPossibleCombos(Holding firstHolding, FiveCardsSet river) {
		List<Card> list = new ArrayList<Card>();
		list.add(firstHolding.getFirstCard());
		list.add(firstHolding.getSecondCard());
		list.add(river.getFirstCard());
		list.add(river.getSecondCard());
		list.add(river.getThirdCard());
		list.add(river.getFourthCard());
		list.add(river.getFifthCard());
		return list;
	}
	
	private void calculateWinner() {
		Setup first = calculateTheHighestSetup(listWith7CardToCheckFirstPlayer);
		Setup second = calculateTheHighestSetup(listWith7CardToCheckSecondPlayer);
		winner = pointWinner(first, second);
	}

	private Setup calculateTheHighestSetup(List<Card> listWith7CardToCheckFirstPlayer) {
		TheHighestSetupChecker oc = new TheHighestSetupChecker(listWith7CardToCheckFirstPlayer);
		Setup winningSetup = oc.getTheHighestSetup();
		return winningSetup;
	}
	
	private Winner pointWinner(Setup wr, Setup wr2) {
		if(wr.equals(wr2))
			return Winner.DRAW;

		return SetupComparator.pointWinner(wr, wr2);
	}
}
