package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;<<<<<<<HEAD
import java.util.Iterator;=======>>>>>>>feature/FonctionnaliteCounter

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
<<<<<<< HEAD
	 * Read a file of symtpoms strings
	 * 
	 * @return A list of strings from a symptoms file
=======
	 * Read a file of symptoms strings
	 * 
	 * @return A list of Symptoms strings
>>>>>>> feature/FonctionnaliteCounter
	 * 
	 */
	@Override
	public ArrayList<String> getSymptoms() {

		ArrayList<String> listOfSymptoms = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					listOfSymptoms.add(line);
					line = reader.readLine();
				}
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

<<<<<<< HEAD
		return result;
	}

	/**
	 * 
	 * Read a file of symtpoms strings
	 * 
	 * @return A list of strings from a symptoms file
	 * 
	 */
//	@Override
//	public ArrayList<String> RemoveDuplicates(ArrayList<String> listOfReadSymptomsAndNoSorted) {
//
//		ArrayList<String> listOfSortedSymptoms = listOfReadSymptomsAndNoSorted;
//		// Integer index = 0;
//		Iterator<String> itLoss = listOfSortedSymptoms.iterator();
//		// Iterator<String> itLorsans = listOfReadSymptomsAndNoSorted.iterator();
//
//		try {
//
//			Collections.sort(listOfReadSymptomsAndNoSorted);
//
//			while (itLoss.hasNext()) {
//				String oneString = itLoss.next();
//				if (oneString.contains(itLoss.next())) {
//					itLoss.remove();
//				}
//			}
//
////			while (index < listOfReadSymptomsAndNoSorted.size()) {
////				if (!(listOfReadSymptomsAndNoSorted.get(index)
////						.contains(listOfReadSymptomsAndNoSorted.get(index + 1)))) {
////					listOfSortedSymptoms.add(listOfReadSymptomsAndNoSorted.get(index));
////				}
////				index += 1;
////			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return listOfSortedSymptoms;
//	}

	@Override
	public ArrayList<Integer> getCounters(ArrayList<String> listOfReadSymptoms) {

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

//	@Override
//	public HashMap<String, Integer> TransformListIntoMap(ArrayList<String> listOfSymptoms,
//			ArrayList<Integer> listOfCounters) {
//
//		HashMap<String, Integer> mapOfSymptomsAndTheirCounter = new HashMap<String, Integer>();
//		Integer index = 0;
//
//		for (String s : listOfSymptoms) {
//			mapOfSymptomsAndTheirCounter.put(s, listOfCounters.get(index));
//			index += 1;
//		}
//
////		for (String s : mapOfSymptomsAndTheirCounter.keySet()) {
////			mapOfSymptomsAndTheirCounter.remove(s);
////		}
////
////		for (String i : mapOfSymptomsAndTheirCounter.keySet()) {
////			System.out.println("key: " + i + " value: " + mapOfSymptomsAndTheirCounter.get(i));
////		}
//
//		return mapOfSymptomsAndTheirCounter;
//	}
	=======return listOfSymptoms;
}>>>>>>>feature/FonctionnaliteCounter

}
