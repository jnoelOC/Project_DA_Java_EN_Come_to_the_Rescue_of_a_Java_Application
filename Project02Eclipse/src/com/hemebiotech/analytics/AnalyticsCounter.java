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
	 * main
	 * 
	 * @param args the arguments
	 * @throws Exception the management of errors
	 */
	public static void main(String args[]) throws Exception {

		String symptomsPathAndFilename = "Project02Eclipse//symptoms.txt";
		String resultsPathAndFilename = "Project02Eclipse//result.out";

		ArrayList<String> listOfSymptoms = new ArrayList<String>();
		TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter = new TreeMap<String, Integer>();

		Analyze an1 = new Analyze(new ReadSymptomDataFromFile(symptomsPathAndFilename), new TreatData(),
				new WriteResultDataInFile(resultsPathAndFilename));

		listOfSymptoms = an1.GetSymptoms();

		treeMapOfSymptomsAndTheirCounter = an1.Calculate(listOfSymptoms);

		an1.WriteResults(treeMapOfSymptomsAndTheirCounter);

		System.out.println("Projet 02");

	}
}
