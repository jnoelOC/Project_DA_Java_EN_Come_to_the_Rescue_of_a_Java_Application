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
	 * @param filepath      a full or partial path to file containing list of
	 *                      results
	 * 
	 * @param listOfResults to write into Result.out file, one per line
	 *
	 */
	public WriteResultDataInFile(String filepath) {

		this.filepath = filepath;
	}

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
