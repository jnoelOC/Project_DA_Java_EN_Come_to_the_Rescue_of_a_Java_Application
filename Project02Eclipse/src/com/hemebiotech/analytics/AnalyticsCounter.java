package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 
 * @author jean-noel.chambe
 *
 */
public class AnalyticsCounter {
	/**
	 * main program which read a file of symptoms, calculate counters and write
	 * results into another file
	 * 
	 * @param args the arguments
	 * @throws Exception the management of errors
	 */
	public static void main(String args[]) throws Exception {

		String symptomsPathAndFilename = "Project02Eclipse//symptoms.txt";
		String resultsPathAndFilename = "Project02Eclipse//result.out";

		Analyze an1 = new Analyze(new ReadSymptomDataFromFile(symptomsPathAndFilename), new TreatData(),
				new WriteResultDataInFile(resultsPathAndFilename));

		ArrayList<String> listOfSymptoms = an1.getSymptoms();

		TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter = an1.calculate(listOfSymptoms);

		an1.writeResults(treeMapOfSymptomsAndTheirCounter);

		System.out.println("Projet 02");

	}
}
