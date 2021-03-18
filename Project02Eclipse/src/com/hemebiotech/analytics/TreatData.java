package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class TreatData implements ISymptomTreater {

	/**
	 * 
	 * Constructor empty.
	 */
	public TreatData() {

	}

	/**
	 * 
	 * From symptoms, calculate their associated counters
	 * 
	 * @param listOfReadSymptoms List of read symptoms
	 * 
	 * @return list of counters integers
	 * 
	 */
	@Override
	public ArrayList<Integer> RetrieveCounters(ArrayList<String> listOfReadSymptoms) {

		ArrayList<String> listOfSymptoms = listOfReadSymptoms;
		ArrayList<Integer> listOfCounters = new ArrayList<Integer>();

		Iterator<String> itLos = listOfSymptoms.iterator();
		Iterator<String> itLors = listOfReadSymptoms.iterator();

		Integer counter = 0;
		try {
			while (itLors.hasNext()) {
				String oneStrLors = itLors.next();
				while (itLos.hasNext()) {
					String oneStrLos = itLos.next();
					if (oneStrLors.contains(oneStrLos)) {
						counter += 1;
					}
				}

				listOfCounters.add(counter);
				counter = 0;
				itLos = listOfSymptoms.iterator(); // reinitialize itLos
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfCounters;
	}

	/**
	 * 
	 * Transform the list of symptoms and the list of associated counters into a
	 * TreeMap.
	 * 
	 * @param listOfSymptoms list of symptoms strings
	 * 
	 * @param listOfCounters list of counters integers
	 * 
	 * @return treeMap of symptoms and their Counter
	 * 
	 */
	@Override
	public TreeMap<String, Integer> TransformListsIntoTreeMap(ArrayList<String> listOfSymptoms,
			ArrayList<Integer> listOfCounters) {

		TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter = new TreeMap<String, Integer>();
		Integer index = 0;

		try {
			for (String s : listOfSymptoms) {
				treeMapOfSymptomsAndTheirCounter.put(s, listOfCounters.get(index));
				index += 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treeMapOfSymptomsAndTheirCounter;
	}

}
