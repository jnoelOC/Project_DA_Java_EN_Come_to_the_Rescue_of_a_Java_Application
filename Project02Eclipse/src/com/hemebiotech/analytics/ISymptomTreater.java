package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Treat two lists, one of symptoms and one of counters and fill a treeMap (thus
 * sorted)
 * 
 */
public interface ISymptomTreater {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @param listOfReadSymptomsWithDuplicates a listing of read symptoms with
	 *                                         possibly duplicates
	 * 
	 * @return a list of all symptoms associated counters
	 *
	 */
	ArrayList<Integer> RetrieveCounters(ArrayList<String> listOfReadSymptomsWithDuplicates);

	/**
	 * If no data is available, return an empty Map
	 * 
	 * @param listOfResults  a list of symptoms
	 *
	 * @param listOfCounters a list of counters
	 *
	 * @return a treeMap of all symptoms obtained with their associated counter
	 *
	 */
	TreeMap<String, Integer> TransformListsIntoTreeMap(ArrayList<String> listOfResults,
			ArrayList<Integer> listOfCounters);

}
