package com.kreasi.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.kreasi.app.validator.DateValid;
import com.kreasi.app.validator.SocialSecValid;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReqPersonDto {

    @Size(max=50,min=2,message="min 2 char, max 50 char, alphanumeric")
	@NotBlank(message = "cant empty value")
	private String name;

	@SocialSecValid
	private String socialNumber;

	@DateValid
	private String dateOfBirth;
	
}
