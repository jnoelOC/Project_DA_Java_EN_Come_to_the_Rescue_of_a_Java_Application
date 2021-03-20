package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class TreatData implements ISymptomTreater {

	/**
	 * 
	 * Constructor
	 */
	public TreatData() {

	}

	/**
	 * 
	 * Retrieve, from the list of symptoms, the list of associated counters and put
	 * into a TreeMap.
	 * 
	 * @param listOfSymptoms list of symptoms strings
	 * 
	 * @return treeMap of symptoms and their Counter associated and sorted
	 * 
	 */
	public TreeMap<String, Integer> retrieveCountersFromSymptomsIntoTreeMap(ArrayList<String> listOfSymptoms) {
		TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter = new TreeMap<String, Integer>();

		for (String element : listOfSymptoms) {
			if (!treeMapOfSymptomsAndTheirCounter.containsKey(element)) {
				treeMapOfSymptomsAndTheirCounter.put(element, 1);
			} else {
				treeMapOfSymptomsAndTheirCounter.put(element, treeMapOfSymptomsAndTheirCounter.get(element) + 1);
			}
		}

		return treeMapOfSymptomsAndTheirCounter;

	}
}
