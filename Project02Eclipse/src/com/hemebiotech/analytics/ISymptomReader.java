package com.hemebiotech.analytics;

import java.util.ArrayList;

/**
 * Read symptoms data from a source (file or database or API Rest). return a
 * list of strings, that may contain many duplicates
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	ArrayList<String> GetSymptoms();

<<<<<<< HEAD
	/**
	 * If no data is available, return an empty List
	 * 
	 * @param a listing of read symptoms without duplicates
	 * 
	 * @return a listing of all symptoms counters obtained
	 *
	 */
	ArrayList<Integer> GetCounters(ArrayList<String> listOfReadSymptomsWithoutDuplicates);

	/**
	 * If no data is available, return an empty List
	 * 
	 * @param a listing of read symptoms with duplicates and no sorted
	 * 
	 * @return a listing of all symptoms obtained, without duplicates
	 *
	 */
	// ArrayList<String> RemoveDuplicates(ArrayList<String>
	// listOfReadSymptomsAndNoSorted);

	/**
	 * If no data is available, return an empty Map
	 * 
	 * @param a listing of symptoms and a listing of their counter
	 * 
	 * @return a map of all symptoms obtained with their associated counter
	 *
	 */
	// HashMap<String, Integer> TransformListIntoMap(ArrayList<String>
	// listOfResults, ArrayList<Integer> listOfCounters);
=======
>>>>>>> feature/FonctionnaliteCounter
}
