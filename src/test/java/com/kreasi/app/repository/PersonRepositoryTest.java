package com.kreasi.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kreasi.app.entity.Person;

@DataJpaTest
class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	void getPersonByIdTest() throws Exception{
		Person p =personRepository.getPersonById(1L).orElse(null);
		assertNotNull(p);
	}

	@Test
	void getgetPersonBySocialNumber() throws Exception {
		Person p =personRepository.getPersonBySocialNumber("00001").orElse(null);
		assertNotNull(p);
	}
}
