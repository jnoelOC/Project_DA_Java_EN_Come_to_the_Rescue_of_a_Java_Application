package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
	 * Read a file of symtpoms strings
	 * 
	 * @return A list of strings from a symptoms file
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

		return listOfSymptoms;
	}

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

}
