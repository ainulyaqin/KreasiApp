package com.kreasi.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kreasi.app.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

	@Query("select o from Person o where o.socialNumber=?1 ")
	Optional<Person> getPersonBySocialNumber(String socialNumber);
	
	@Query("select o from Person o where o.isDeleted=false and o.id=?1 ")
	Optional<Person> getPersonById(Long id);
	
}
