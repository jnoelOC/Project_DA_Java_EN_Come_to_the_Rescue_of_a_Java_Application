package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 
 *
 * This class allows to read a file of symptoms, calculate counters and write
 * into a file the results, via 3 interfaces
 *
 * @author jean-noel.chambe
 *
 */
public class Analyze {

	private ISymptomReader reader;
	private ISymptomTreater treater;
	private IResultWriter writer;

	/**
	 * Constructor of Analyze
	 * 
	 * @param reader  interface
	 * @param treater interface
	 * @param writer  interface
	 */
	public Analyze(ISymptomReader reader, ISymptomTreater treater, IResultWriter writer) {

		this.reader = reader;
		this.treater = treater;
		this.writer = writer;
	}

	/**
	 * 
	 * Call getSymptoms method
	 * 
	 * @return a list of symptoms strings
	 * 
	 */
	public ArrayList<String> getSymptoms() {

		ArrayList<String> listOfSymptoms = reader.getSymptoms();

		return listOfSymptoms;
	}

	/**
	 * 
	 * Calculate, from list of symptoms, a treeMap of symptoms with their counters
	 * 
	 * @param listOfSymptoms list of symptoms strings
	 * 
	 * @return a treeMap containing symptoms and their counters
	 */
	public TreeMap<String, Integer> calculate(ArrayList<String> listOfSymptoms) {

		TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter = treater
				.retrieveCountersFromSymptomsIntoTreeMap(listOfSymptoms);

		return treeMapOfSymptomsAndTheirCounter;
	}

	/**
	 * 
	 * Call setResults method
	 * 
	 * @param treeMapOfSymptomsAndTheirCounter treeMap of symptoms and their
	 *                                         counters
	 */
	public void writeResults(TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter) {
		writer.setResults(treeMapOfSymptomsAndTheirCounter);
	}

}
