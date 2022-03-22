package com.kreasi.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@JsonInclude(Include.NON_NULL)
public class PersonDto {

	private Long id;
	
	private String name;
	
	private String socialNumber;
	
	private String dateOfBirth;
	
	private String createdDate;
	
	private String updatedDate;
	
	private String createdBy;
	
}
