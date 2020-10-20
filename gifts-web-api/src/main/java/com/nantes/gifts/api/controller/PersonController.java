package com.nantes.gifts.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.nantes.gifts.api.bean.Person;
import com.nantes.gifts.api.exception.RessourceNotFoundException;
import com.nantes.gifts.api.repository.PersonRepository;

@RestController
@RequestMapping("/api/")
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
	
	//Get all persons
	@GetMapping("person")
	public List<Person> getAllPerson(){
		return this.personRepository.findAll();
	}
	
	//Get person by id
	@GetMapping("person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId){
		
		Optional<Person> optPerson = personRepository.findById(personId);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			return ResponseEntity.ok().body(person);
		} else {
			throw new RessourceNotFoundException("Person not found for this id :: " + personId); //return a 404
		}
		
	}
	
	
	// save person
	@PostMapping("person")
	public Person createPerson(@RequestBody Person person) {
		return this.personRepository.save(person);
	}
	
	
	//update person
	@PutMapping("person/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
			@Validated @RequestBody Person personDetails) throws RessourceNotFoundException {
		
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new RessourceNotFoundException("Person not found for this id :: " + personId));
		
		person.setCompleteName(personDetails.getCompleteName());
		person.setNickName(personDetails.getCompleteName());
		person.setBirthDate(personDetails.getBirthDate());
		person.setPicture(personDetails.getPicture());
		person.setActive(personDetails.isActive());
		
		return ResponseEntity.ok(this.personRepository.save(person));
			
	}
	
	
	//delete person
	@DeleteMapping("person/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId) throws RessourceNotFoundException {
		
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new RessourceNotFoundException("Person not found for this id :: " + personId));
		
		this.personRepository.delete(person);
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("person " + personId +"deleted", Boolean.TRUE);
		return response;
		
	}

}
