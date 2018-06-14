package com.calculator.poker.generators;

import java.util.ArrayList;
import java.util.List;

public class CombinationGenerator {
	
	public static <T> List<List<T>> getCombinations(int k, List<T> list) {
	    List<List<T>> combinations = new ArrayList<List<T>>();
	    if (k == 0) {
	        combinations.add(new ArrayList<T>());
	        return combinations;
	    }
	    for (int i = 0; i < list.size(); i++) {
	        T element = list.get(i);
	        List<T> rest = getSublist(list, i+1);
	        for (List<T> previous : getCombinations(k-1, rest)) {
	            previous.add(element);
	            combinations.add(previous);
	        }
	    }
	    return combinations;
	}

	public static <T> List<T> getSublist(List<T> list, int i) {
	    List<T> sublist = new ArrayList<T>();
	    for (int j = i; j < list.size(); j++) {
	        sublist.add(list.get(j));
	    }
	    return sublist;
	}
	
	
}
