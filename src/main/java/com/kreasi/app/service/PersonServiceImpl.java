package com.kreasi.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kreasi.app.dto.PersonDto;
import com.kreasi.app.dto.ReqPersonDto;
import com.kreasi.app.entity.Person;
import com.kreasi.app.exception.ConflictException;
import com.kreasi.app.exception.DataNotFoundException;
import com.kreasi.app.repository.PersonRepository;
import com.kreasi.app.util.DateUtil;
import com.kreasi.app.util.StringUtil;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public ResponseEntity<PersonDto>  getUser(Long id) throws Exception {
		
		Person p = personRepository.getPersonById(id).orElseThrow(()->new DataNotFoundException(id+"@id not found "));
		
		PersonDto dto = toPersonDto(p);
		
		return new ResponseEntity<PersonDto>(dto,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PersonDto>  saveUser(ReqPersonDto reqPersonDto) throws Exception {
		
		PersonDto dto = null;
		
		try {
			
			Person p = new Person();
			p.setDateOfBirth(DateUtil.toDate(reqPersonDto.getDateOfBirth()));
			p.setIsDeleted(Boolean.FALSE);
			p.setName(reqPersonDto.getName());
			p.setSocialNumber(reqPersonDto.getSocialNumber());
			p.setCreatedDate(new Date());
			
			personRepository.save(p);
			
			dto = toPersonDto(p);
			
		} catch (DataIntegrityViolationException e) {
			throw new ConflictException(reqPersonDto.getSocialNumber()+"@id not found ");
		}
		
		return new ResponseEntity<PersonDto>(dto,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<PersonDto>  updateUser(ReqPersonDto reqPersonDto) throws Exception {
		
		Person p = personRepository.getPersonBySocialNumber(reqPersonDto.getSocialNumber())
				.orElseThrow(()->new DataNotFoundException(reqPersonDto.getSocialNumber()+"@id not found "));
				
		p.setDateOfBirth(DateUtil.toDate(reqPersonDto.getDateOfBirth()));
		p.setName(reqPersonDto.getName());
		p.setUpdatedDate(new Date());
		
		personRepository.save(p);
		
		PersonDto dto = toPersonDto(p);
		
		return new ResponseEntity<PersonDto>(dto,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<String> deleteUser(Long id) throws Exception {
		
		
		Person p = personRepository.findById(id).orElseThrow(()->new DataNotFoundException(id+"@id not found "));
		
		p.setIsDeleted(Boolean.TRUE);
		
		personRepository.save(p);
		
		return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
	}
	
	private PersonDto toPersonDto(Person p) {
		return PersonDto.builder()
				.id(p.getId())
				.name(StringUtil.nullToEmpty(p.getName()))
				.createdBy(StringUtil.nullToEmpty(p.getCreatedBy()))
				.createdDate(StringUtil.nullToEmpty(p.getCreatedDate()))
				.socialNumber(StringUtil.nullToEmpty(p.getSocialNumber()))
				.dateOfBirth(StringUtil.nullToEmpty(p.getDateOfBirth()))
				.updatedDate(StringUtil.nullToEmpty(p.getUpdatedDate()))
				.build(); 
	}

}
