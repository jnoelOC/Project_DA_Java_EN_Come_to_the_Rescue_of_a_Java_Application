package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 
 * Run AnalyticsCounter which read symptoms, count them and write results into
 * an output file
 * 
 * @author jean-noel.chambe
 *
 */
public class AnalyticsCounter {
	/**
	 * main program which read a file of symptoms, calculate counters and write
	 * results into an output file
	 * 
	 * @param args the arguments
	 * @throws Exception the management of errors
	 */
	public static void main(String args[]) throws Exception {

		// the input file and the output file
		String symptomsPathAndFilename = "Project02Eclipse//symptoms.txt";
		String resultsPathAndFilename = "Project02Eclipse//result.out";

		// Instantiate an analyze
		Analyze an1 = new Analyze(new ReadSymptomDataFromFile(symptomsPathAndFilename), new TreatData(),
				new WriteResultDataInFile(resultsPathAndFilename));

		// Read symptoms from input file
		ArrayList<String> listOfSymptoms = an1.getSymptoms();

		// Calculate counters
		TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter = an1.calculate(listOfSymptoms);

		// Write symptoms and their counter into output file
		an1.writeResults(treeMapOfSymptomsAndTheirCounter);

		System.out.println("Projet 02");

	}
}
