package com.kreasi.app.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.kreasi.app.util.DateUtil;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateDtoValidator.class)
@Documented
public @interface DateValid {

	String message() default "Invalid date format "+DateUtil.POJO_DATE_FORMAT;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
