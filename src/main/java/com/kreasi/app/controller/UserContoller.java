package com.kreasi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kreasi.app.dto.PersonDto;
import com.kreasi.app.dto.ReqPersonDto;
import com.kreasi.app.service.PersonService;

@RestController
@RequestMapping("/v1/users")
public class UserContoller {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonDto> getUser(@PathVariable Long id) throws Exception {
		return personService.getUser(id);
	}
	
	@PostMapping
	public ResponseEntity<PersonDto> postUser( @RequestBody @Validated ReqPersonDto dto) throws Exception {
		return personService.saveUser(dto);
	}
	
	@PutMapping
	public ResponseEntity<PersonDto> updateUser( @RequestBody @Validated ReqPersonDto dto) throws Exception {
		return personService.updateUser(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
		return personService.deleteUser(id);
	}
	
}
