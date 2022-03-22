package com.kreasi.app.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SocialSecDtoValidator.class)
@Documented
public @interface SocialSecValid {

	String message() default "Invalid social format must be 5 digit numeric, pad with zero if less than 5 digits ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
