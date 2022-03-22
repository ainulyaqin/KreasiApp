package com.kreasi.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.kreasi.app.dto.PersonDto;
import com.kreasi.app.dto.ReqPersonDto;
import com.kreasi.app.entity.Person;
import com.kreasi.app.exception.DataNotFoundException;
import com.kreasi.app.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

	@InjectMocks
	private PersonServiceImpl trackingServiceImpl;

	@Mock
	private PersonRepository personRepository;
	
	@Test
	public void getUserTest() throws Exception {
	
		Person p = new Person();
		p.setCreatedBy("");
		p.setName("ainul");
		p.setCreatedDate(new Date());
		p.setDateOfBirth(new Date());
		
		Mockito.when(personRepository.getPersonById(Mockito.anyLong())).thenReturn(Optional.ofNullable(p));
		
		ResponseEntity<PersonDto> dto = trackingServiceImpl.getUser(1L);
		
		assertEquals(dto.getBody().getName(), "ainul");
		
	}
	
	@Test
	public void updateUserTest() throws Exception {
	
		Person p1 = new Person();
		p1.setCreatedBy("");
		p1.setName("ainul");
		p1.setCreatedDate(new Date());
		p1.setDateOfBirth(new Date());
		
		ReqPersonDto p = new ReqPersonDto();
		
		p.setName("ainul");
		p.setSocialNumber("11111");
		p.setDateOfBirth("2020-11-11");
		
		Mockito.when(personRepository.getPersonBySocialNumber(Mockito.anyString())).thenReturn(Optional.ofNullable(p1));
		
		ResponseEntity<PersonDto> dto = trackingServiceImpl.updateUser(p);
		
		assertEquals(dto.getBody().getName(), "ainul");
		
	}
	
	@Test
	public void deleteUserTest() throws Exception {
	
		Person p1 = new Person();
		p1.setCreatedBy("");
		p1.setName("ainul");
		p1.setCreatedDate(new Date());
		p1.setDateOfBirth(new Date());
		
		Mockito.when(personRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(p1));
		
		ResponseEntity<String> dto = trackingServiceImpl.deleteUser(1L);
		
		assertEquals(dto.getBody(), "");
		
	}
	
	
	@Test
	public void saveUserTest() throws Exception {
	
		ReqPersonDto p = new ReqPersonDto();
		
		p.setName("ainul");
		p.setSocialNumber("11111");
		p.setDateOfBirth("2020-11-11");
		
		
		ResponseEntity<PersonDto> dto = trackingServiceImpl.saveUser(p);
		
		assertEquals(dto.getBody().getName(), "ainul");
		
	}
	
}
