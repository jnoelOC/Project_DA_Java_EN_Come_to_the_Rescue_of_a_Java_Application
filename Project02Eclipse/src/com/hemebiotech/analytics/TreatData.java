package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Simple brute force implementation
 *
 */
public class TreatData implements ISymptomTreater {

	private String filepath;

	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * @param filepath the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public TreatData(String filepath) {
		this.setFilepath(filepath);
	}

	@Override
	public ArrayList<String> RemoveDuplicates(ArrayList<String> listOfReadSymptomsAndNoSorted) {

		ArrayList<String> listOfSortedSymptoms = listOfReadSymptomsAndNoSorted;
		// Integer index = 0;
		Iterator<String> itLoss = listOfSortedSymptoms.iterator();
		// Iterator<String> itLorsans = listOfReadSymptomsAndNoSorted.iterator();

		try {

			Collections.sort(listOfReadSymptomsAndNoSorted);

			while (itLoss.hasNext()) {
				String oneString = itLoss.next();
				if (oneString.contains(itLoss.next())) {
					itLoss.remove();
				}
			}

//			while (index < listOfReadSymptomsAndNoSorted.size()) {
//				if (!(listOfReadSymptomsAndNoSorted.get(index)
//						.contains(listOfReadSymptomsAndNoSorted.get(index + 1)))) {
//					listOfSortedSymptoms.add(listOfReadSymptomsAndNoSorted.get(index));
//				}
//				index += 1;
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listOfSortedSymptoms;
	}

	@Override
	public ArrayList<Integer> GetCounters(ArrayList<String> listOfReadSymptoms) {

		ArrayList<String> listOfSymptoms = listOfReadSymptoms;
		ArrayList<Integer> listOfCounters = new ArrayList<Integer>();

		Iterator<String> itLos = listOfSymptoms.iterator();
		Iterator<String> itLors = listOfReadSymptoms.iterator();

		Integer counter = 0;

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

		return listOfCounters;
	}

	@Override
	public HashMap<String, Integer> TransformListIntoMap(ArrayList<String> listOfSymptoms,
			ArrayList<Integer> listOfCounters) {

		HashMap<String, Integer> mapOfSymptomsAndTheirCounter = new HashMap<String, Integer>();
		Integer index = 0;

		for (String s : listOfSymptoms) {
			mapOfSymptomsAndTheirCounter.put(s, listOfCounters.get(index));
			index += 1;
		}

//		for (String s : mapOfSymptomsAndTheirCounter.keySet()) {
//			mapOfSymptomsAndTheirCounter.remove(s);
//		}
//
//		for (String i : mapOfSymptomsAndTheirCounter.keySet()) {
//			System.out.println("key: " + i + " value: " + mapOfSymptomsAndTheirCounter.get(i));
//		}

		return mapOfSymptomsAndTheirCounter;
	}

}
