package br.com.baron.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public Person findById(String id) {
		
		logger.info("Looking for a person");	
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Marco");
		person.setLastName("Baron");
		person.setAddress("Guabiruba - SC - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public List<Person> findAll() {

		logger.info("Looking for all the people");

		List<Person> persons = new ArrayList<>();
		
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	public Person create(Person person) {
		logger.info("Creating a person");
		return person;
	}

	public Person update(Person person) {
		logger.info("Updating a person");
		return person;
	}

	public void delete(Long id) {
		logger.info("Deleting a person");
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("First Name " + i);
		person.setLastName("Last Name " + i);
		person.setAddress("Address " + i);
		person.setGender("Male");
		return person;
	}
}

