package br.com.baron.controllers;

import br.com.baron.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.baron.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private PersonService service;
	
	public PersonController(PersonService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public PersonDto findById(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}

	@GetMapping
	public List<PersonDto> findAll() {
		return service.findAll();
	}

	@PostMapping
	public PersonDto create(@RequestBody PersonDto personDto) {
		return service.create(person);
	}

	@PutMapping
	public PersonDto update(@RequestBody PersonDto personDto) {
		return service.update(person);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

