package br.com.baron.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.baron.services.PersonService;
import br.com.baron.model.Person;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private PersonService service;
	
	public PersonController(PersonService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public Person findById(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Person> findAll() {
		return service.findAll();
	}

	@PostMapping
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}

	@PutMapping
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

