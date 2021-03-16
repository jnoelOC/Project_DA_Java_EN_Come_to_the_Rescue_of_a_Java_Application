package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;

public class Analyze {

	private ArrayList<String> listOfResults;
	private ArrayList<String> intermediateListOfResult;
	private ArrayList<Integer> listOfCounters;
	private HashMap<String, Integer> mapOfSymptomsAndTheirCounter;

	public void TreatSymptomsFile(String symptomsPathAndFilename, String resultsPathAndFilename) {

		ReadSymptomDataFromFile rs = new ReadSymptomDataFromFile(symptomsPathAndFilename);
		listOfResults = rs.GetSymptoms();

		TreatData td = new TreatData(symptomsPathAndFilename);
		listOfCounters = td.GetCounters(listOfResults);

		// Je veux une analyse qui getSymptom en base de données, compteet tri par ordre
		// alpha et qui écrit dans un fichier texte

		mapOfSymptomsAndTheirCounter = td.TransformListIntoMap(listOfResults, listOfCounters);
		// intermediateListOfResult = rs.RemoveDuplicates(listOfResults);

//		WriteResultDataInFile wr = new WriteResultDataInFile(resultsPathAndFilename, mapOfSymptomsAndTheirCounter);
		WriteResultDataInFile wr = new WriteResultDataInFile(resultsPathAndFilename, listOfResults);
		wr.SetResults();

	}
}
