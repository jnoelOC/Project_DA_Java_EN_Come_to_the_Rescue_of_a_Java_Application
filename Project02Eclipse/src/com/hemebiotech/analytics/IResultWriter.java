package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * 
 * Write into anything (file or database or ...) a treeMap of all found results
 * 
 */
public interface IResultWriter {

	/**
	 * Return nothing
	 * 
	 * @param treeMapOfSymptomsAndTheirCounter A treeMap of all Symptoms obtained
	 *                                         from two lists, without duplicates
	 * 
	 */
	void SetResults(TreeMap<String, Integer> treeMapOfSymptomsAndTheirCounter);

}
