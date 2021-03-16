package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

public class Analyze {

	private ReadSymptomDataFromFile readSymptomDataFromFile;
	private TreatData treatData;
	private WriteResultDataInFile writeResultDataInFile;

	public Analyze(ReadSymptomDataFromFile readSymptomDataFromFile, TreatData treatData,
			WriteResultDataInFile writeResultDataInFile) {

		this.readSymptomDataFromFile = readSymptomDataFromFile;
		this.treatData = treatData;
		this.writeResultDataInFile = writeResultDataInFile;
	}

	public ArrayList<String> GetSymptoms() {
		ArrayList<String> listOfSymptoms;

		listOfSymptoms = readSymptomDataFromFile.GetSymptoms();

		return listOfSymptoms;
	}

	public TreeMap<String, Integer> Calculate(ArrayList<String> listOfSymptoms) {
		ArrayList<Integer> listOfCounters;
		TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter;

		listOfCounters = treatData.RetrieveCounters(listOfSymptoms);

		treeMapOfSymptomsAndTheirCounter = treatData.TransformListsIntoTreeMap(listOfSymptoms, listOfCounters);

		return treeMapOfSymptomsAndTheirCounter;
	}

	public void WriteResults(TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter) {
		writeResultDataInFile.SetResults(treeMapOfSymptomsAndTheirCounter);
	}

}
