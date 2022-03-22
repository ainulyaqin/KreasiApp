package com.kreasi.app.service;

import org.springframework.http.ResponseEntity;

import com.kreasi.app.dto.PersonDto;
import com.kreasi.app.dto.ReqPersonDto;

public interface PersonService {

	ResponseEntity<PersonDto> getUser(Long id) throws Exception;
	

	ResponseEntity<PersonDto> saveUser(ReqPersonDto reqPersonDto) throws Exception;
	

	ResponseEntity<PersonDto>  updateUser(ReqPersonDto reqPersonDto) throws Exception;
	

	ResponseEntity<String>  deleteUser(Long id) throws Exception;
	
}
