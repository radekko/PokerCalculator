package com.calculator.poker.model;

import java.util.Arrays;

public class Setup {
	private ShowdownResult showdownResult;
	private int rank[];
	
	public ShowdownResult getShowdownResult() {
		return showdownResult;
	}
	public Setup(ShowdownResult handRanking, int[] rank) {
		this.showdownResult = handRanking;
		this.rank = rank;
	}
	public int[] getRank() {
		return rank;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((showdownResult == null) ? 0 : showdownResult.hashCode());
		result = prime * result + Arrays.hashCode(rank);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setup other = (Setup) obj;
		if (showdownResult != other.showdownResult)
			return false;
		if (!Arrays.equals(rank, other.rank))
			return false;
		return true;
	}
	
}
