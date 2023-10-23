package br.com.baron.services;

import java.util.List;
import java.util.logging.Logger;

import br.com.baron.dto.v1.PersonDto;
import br.com.baron.dto.v2.PersonDtoV2;
import br.com.baron.exceptions.ResourceNotFoundException;
import br.com.baron.mapper.DozerMapper;
import br.com.baron.mapper.PersonMapper;
import br.com.baron.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import br.com.baron.model.Person;

@Service
public class PersonService {
	
	private final Logger logger = Logger.getLogger(PersonService.class.getName());
	private final PersonRepository repository;
	private final PersonMapper personMapper;

	public PersonService(PersonRepository repository, PersonMapper personMapper) {
		this.repository = repository;
		this.personMapper = personMapper;
	}

	public PersonDto findById(Long id) {

		logger.info("Looking for a person");
		Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));
		return DozerMapper.parseObject(person, PersonDto.class);

	}
	
	public List<PersonDto> findAll() {
		logger.info("Looking for all the people");
		return DozerMapper.parseListObjects(repository.findAll(), PersonDto.class);
	}

	public PersonDto create(PersonDto personDto) {
		logger.info("Creating a person");
		Person person = DozerMapper.parseObject(personDto, Person.class);
		repository.save(person);
		return DozerMapper.parseObject(person, PersonDto.class);
	}

	public PersonDtoV2 create(PersonDtoV2 personDto) {
		logger.info("Creating a person with v2");
		Person person = personMapper.convertDtoToEntity(personDto);
		repository.save(person);
		return personMapper.convertEntityToDto(person);
	}

	public PersonDto update(PersonDto personDto) {
		logger.info("Updating a person");

		Person person = repository.findById(personDto.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found."));

		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setAddress(personDto.getAddress());
		person.setGender(personDto.getGender());
		repository.save(person);

        return DozerMapper.parseObject(person, PersonDto.class);
	}

	public void delete(Long id) {
		logger.info("Deleting a person");
		Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found."));;
		repository.delete(person);
	}
}

