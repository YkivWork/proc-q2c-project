package com.merrillcorp.enterprise.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilities {
	
	/**
	 * <h1>Get Formatted Date</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @param date
	 * @return String - Formatted in yyyy-MM-dd
	 */
	public static String getFormatedDate(Date date){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

}
