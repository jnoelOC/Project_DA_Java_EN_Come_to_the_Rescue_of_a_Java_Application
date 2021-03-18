package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 
 * @author jean-noel.chambe
 *
 *         This class allows to read a file of symptoms, calculate counters and
 *         write into a file the results
 *
 */
public class Analyze {

	private ReadSymptomDataFromFile readSymptomDataFromFile;
	private TreatData treatData;
	private WriteResultDataInFile writeResultDataInFile;

	/**
	 * Constructor of Analyze
	 * 
	 * @param readSymptomDataFromFile object
	 * @param treatData               object
	 * @param writeResultDataInFile   object
	 */
	public Analyze(ReadSymptomDataFromFile readSymptomDataFromFile, TreatData treatData,
			WriteResultDataInFile writeResultDataInFile) {

		this.readSymptomDataFromFile = readSymptomDataFromFile;
		this.treatData = treatData;
		this.writeResultDataInFile = writeResultDataInFile;
	}

	/**
	 * 
	 * Call GetSymptoms method
	 * 
	 * @return a list of symptoms strings
	 * 
	 */
	public ArrayList<String> getSymptoms() {
		ArrayList<String> listOfSymptoms;

		listOfSymptoms = readSymptomDataFromFile.getSymptoms();

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
	public TreeMap<String, Integer> Calculate(ArrayList<String> listOfSymptoms) {
		ArrayList<Integer> listOfCounters;
		TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter;

		listOfCounters = treatData.RetrieveCounters(listOfSymptoms);

		treeMapOfSymptomsAndTheirCounter = treatData.TransformListsIntoTreeMap(listOfSymptoms, listOfCounters);

		return treeMapOfSymptomsAndTheirCounter;
	}

	/**
	 * 
	 * Call SetResults method
	 * 
	 * @param treeMapOfSymptomsAndTheirCounter treeMap of symptoms and their
	 *                                         counters
	 */
	public void WriteResults(TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter) {
		writeResultDataInFile.SetResults(treeMapOfSymptomsAndTheirCounter);
	}

}
