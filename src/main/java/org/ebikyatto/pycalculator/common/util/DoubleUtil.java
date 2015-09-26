package org.ebikyatto.pycalculator.common.util;

public final class DoubleUtil {

	private static final String DEFAULT_DELIMITER = ",";

	private DoubleUtil() {
	}

	public static double[] parseDoubleArray(String stringToParse) {
		return parseDoubleArray(stringToParse, DoubleUtil.DEFAULT_DELIMITER);
	}
	
	public static double[] parseDoubleArray(String stringToParse, String delimiter) {
		String[] stringArray = stringToParse.split(delimiter, -1);

		double[] doubleArray = new double[stringArray.length];
		for (int index = 0; index < stringArray.length; index++) {
			double number = parseDouble(stringArray[index]);
			doubleArray[index] = number;
		}
		return doubleArray;
	}
	
	public static double parseDouble(String stringToParse) {
		double number = 0;
		
		if (!stringToParse.isEmpty()) {
			number = Double.parseDouble(stringToParse);
		}
		return number;
	}
}
