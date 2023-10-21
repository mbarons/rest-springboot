package br.com.baron.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.baron.services.PersonService;
import model.Person;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private PersonService service;
	
	public PersonController(PersonService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public Person findById(@PathVariable(value="id") String id) {
		return service.findById(id);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Person> findAll() {
		return service.findAll();
	}

	@RequestMapping(method=RequestMethod.POST)
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
}

