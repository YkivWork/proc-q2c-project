package com.merrillcorp.enterprise.utilities;

public class StringUtilities {
	
	/**
	 * <h1>Trim to Three</h1>
	 * Utility Function to return first three characters of a string
	 * @param stringToTrim
	 * @return String - First three characters of stringToTrim
	 */
	public static String trimToThree(String stringToTrim){
		if(stringToTrim.length() > 2)
			return stringToTrim.substring(0,3);
		else 
			return stringToTrim;
	}
}
