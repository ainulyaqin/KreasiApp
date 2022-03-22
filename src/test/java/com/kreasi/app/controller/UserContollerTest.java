package com.kreasi.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.kreasi.app.dto.PersonDto;
import com.kreasi.app.service.PersonServiceImpl;

@WebMvcTest(value = UserContoller.class)
class UserContollerTest {

	@MockBean
	private PersonServiceImpl personService;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getUserTest() throws Exception {

		//final String json = "{\"name\":\"string\",\"socialNumber\":\"11112\",\"dateOfBirth\":\"2020-11-11\"}";
		
		ResponseEntity<PersonDto> p = new ResponseEntity<PersonDto>(HttpStatus.OK);
		
		Mockito.when(personService.getUser(Mockito.anyLong())).thenReturn(p);

		mockMvc.perform(get("/v1/users/1").contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	void postUserTest() throws Exception {

		final String json = "{\"name\":\"string\",\"socialNumber\":\"11112\",\"dateOfBirth\":\"2020-11-11\"}";
		
		ResponseEntity<PersonDto> p = new ResponseEntity<PersonDto>(HttpStatus.OK);
		
		Mockito.when(personService.saveUser(Mockito.any())).thenReturn(p);

		mockMvc.perform(post("/v1/users").contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isOk());
	}
	
	@Test
	void putUserTest() throws Exception {

		final String json = "{\"name\":\"string\",\"socialNumber\":\"11112\",\"dateOfBirth\":\"2020-11-11\"}";
		
		ResponseEntity<PersonDto> p = new ResponseEntity<PersonDto>(HttpStatus.OK);
		
		Mockito.when(personService.saveUser(Mockito.any())).thenReturn(p);

		mockMvc.perform(put("/v1/users").contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isOk());
	}
	
	@Test
	void deleteUserTest() throws Exception {

		final String json = "{\"name\":\"string\",\"socialNumber\":\"11112\",\"dateOfBirth\":\"2020-11-11\"}";
		
		ResponseEntity<PersonDto> p = new ResponseEntity<PersonDto>(HttpStatus.OK);
		
		Mockito.when(personService.saveUser(Mockito.any())).thenReturn(p);

		mockMvc.perform(delete("/v1/users/1").contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isOk());
	}

}
