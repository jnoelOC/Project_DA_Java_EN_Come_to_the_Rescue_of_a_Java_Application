package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class WriteResultDataInFile implements IResultWriter {

	private String filepath;

	/**
	 * 
	 * @param filepath a full path to file containing list of results
	 * 
	 * 
	 */
	public WriteResultDataInFile(String filepath) {

		this.filepath = filepath;
	}

	/**
	 * 
	 * Write the symptoms and their counters into a file
	 * 
	 * @param treeMapOfSymptomsAndTheirCounter containing the symptoms string with
	 *                                         their counters integer
	 * 
	 */
	@Override
	public void SetResults(TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter) {

		if (filepath != null) {
			try {
				FileWriter writer = new FileWriter(filepath);

				for (String s : treeMapOfSymptomsAndTheirCounter.keySet()) {
					writer.write(s + " = " + treeMapOfSymptomsAndTheirCounter.get(s) + "\n");
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
