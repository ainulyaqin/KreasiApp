package com.kreasi.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String POJO_DATE_FORMAT 	= "yyyy-MM-dd";

	public static Date toDate(String date) throws Exception {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(POJO_DATE_FORMAT);
		
		try {
			if(date==null) throw new Exception("date can be null");
			
			return simpleDateFormat.parse(date);
		} catch (Exception e) {
			throw new Exception("Error Parsing date "+date);
		}
	}
	
}
