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
	 * If no data is available, return an empty Map
	 * 
	 * @param listOfSymptoms a list of symptoms
	 *
	 * @return a treeMap of all symptoms obtained with their associated counter
	 *
	 */
	TreeMap<String, Integer> retrieveCountersFromSymptomsIntoTreeMap(ArrayList<String> listOfSymptoms);

}
