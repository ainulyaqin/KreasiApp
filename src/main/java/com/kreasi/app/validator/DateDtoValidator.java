package com.kreasi.app.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateDtoValidator implements ConstraintValidator<DateValid, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value==null) return false;
		
		/*
		 * yyyy-MM-dd
		 */
		final String DATE_REGEX = "^([0-9]{4})-([0-1][0-9])-([0-3][0-9])$";
		 
		return Pattern.matches(DATE_REGEX, value); 
	}

}
