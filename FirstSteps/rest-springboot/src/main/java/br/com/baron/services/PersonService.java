package br.com.baron.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import br.com.baron.dto.PersonDto;
import br.com.baron.exceptions.ResourceNotFoundException;
import br.com.baron.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import br.com.baron.model.Person;

@Service
public class PersonService {
	
	private final Logger logger = Logger.getLogger(PersonService.class.getName());
	private final PersonRepository repository;

	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}

	public PersonDto findById(Long id) {
		
		logger.info("Looking for a person");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
	}
	
	public List<PersonDto> findAll() {
		logger.info("Looking for all the people");
		return repository.findAll();
	}

	public PersonDto create(PersonDto personDto) {
		logger.info("Creating a person");
		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("Updating a person");
		Person entity = findById(person.getId());

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(person);
	}

	public void delete(Long id) {
		logger.info("Deleting a person");
		Person person = findById(id);
		repository.delete(person);
	}
}

