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
	ArrayList<String> getSymptoms();

	/**
	 * If no data is available, return an empty List
	 * 
	 * @param a listing of read symptoms without duplicates
	 * 
	 * @return a listing of all symptoms counters obtained
	 *
	 */
	ArrayList<Integer> getCounters(ArrayList<String> listOfReadSymptomsWithoutDuplicates);

}
