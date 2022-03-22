package com.kreasi.app.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SocialSecDtoValidator implements ConstraintValidator<SocialSecValid, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		

		if(value==null) return false;
		
		/*
		 * yyyy-MM-dd
		 */
		final String DATE_REGEX = "^\\d{5}$";
		
		return Pattern.matches(DATE_REGEX, value); 
	}

}
