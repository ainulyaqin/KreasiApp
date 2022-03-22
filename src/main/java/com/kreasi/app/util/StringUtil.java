package com.kreasi.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StringUtil {

	public static final String EMPTY_STRING 			= "";
	
	public static final String ZERO_STRING 				= "0";
	
	public static final String FALSE_STRING 			= "false";
	
	public static String nullToEmpty(String s) {
		if(s==null) {
			return EMPTY_STRING;
		}
		return s;
	}
	
	public static String nullToEmpty(Integer s) {
		if(s==null) {
			return ZERO_STRING;
		}
		return s.toString();
	}
	
	public static String nullToEmpty(Date s) {
		if(s==null) {
			return EMPTY_STRING;
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.POJO_DATE_FORMAT);
		try {
			return simpleDateFormat.format(s);
		} catch (Exception e) {
			log.error("error parsing s date "+e.getMessage());
			return EMPTY_STRING;
		}
	}
}
