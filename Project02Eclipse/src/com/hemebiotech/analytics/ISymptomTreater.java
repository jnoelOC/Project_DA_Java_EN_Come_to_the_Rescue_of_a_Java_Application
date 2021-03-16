package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomTreater {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @param a listing of read symptoms without duplicates
	 * 
	 * @return a listing of all symptoms counters obtained
	 *
	 */
	ArrayList<Integer> RetrieveCounters(ArrayList<String> listOfReadSymptomsWithDuplicates);

	/**
	 * If no data is available, return an empty Map
	 * 
	 * @param a listing of symptoms and a listing of their counter
	 * 
	 * @return a map of all symptoms obtained with their associated counter
	 *
	 */
	TreeMap<String, Integer> TransformListsIntoTreeMap(ArrayList<String> listOfResults,
			ArrayList<Integer> listOfCounters);

}
