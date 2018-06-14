package com.calculator.poker;

import com.calculator.poker.model.Card;
import com.calculator.poker.model.CardColor;
import com.calculator.poker.model.CardFigure;
import com.calculator.poker.model.Holding;

public class Main 
{
    public static void main( String[] args )
    {
    	Holding holding = new Holding(
    			new Card(CardFigure.ACE,CardColor.CLUB),
    			new Card(CardFigure.ACE,CardColor.DIAMOND));
    	
    	Holding holding2 = new Holding(
    			new Card(CardFigure.TWO,CardColor.CLUB),
    			new Card(CardFigure.TWO,CardColor.DIAMOND));
    	
//    	Holding holding = new Holding(
//    			new Card(CardFigure.EIGHT,CardColor.CLUB),
//    			new Card(CardFigure.SEVEN,CardColor.CLUB));
//    	
//    	Holding holding2 = new Holding(
//    			new Card(CardFigure.TWO,CardColor.CLUB),
//    			new Card(CardFigure.TWO,CardColor.DIAMOND));
    	ListOfPossibleCardsOnTable lop = new ListOfPossibleCardsOnTable();
    	WinningProbabilityCreator rc =
    			new WinningProbabilityCreator(holding,holding2,lop);
    	
    	rc.printResult();
    }
}
