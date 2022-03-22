package com.kreasi.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique=true)
	private String socialNumber;
	
	private Date dateOfBirth;
	
	private Date createdDate;
	
	private Date updatedDate;
	
	private String updatedBy = "SPRING_BOOT_TEST";
	
	private String createdBy ="SPRING_BOOT_TEST" ;
	
	private Boolean isDeleted = false;
	
}
