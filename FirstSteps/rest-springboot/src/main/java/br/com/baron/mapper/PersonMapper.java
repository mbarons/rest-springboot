package br.com.baron.mapper;

import br.com.baron.dto.v2.PersonDtoV2;
import br.com.baron.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonDtoV2 convertEntityToDto(Person person) {
        PersonDtoV2 dto = new PersonDtoV2();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        dto.setBirthday(new Date());

        return dto;
    }

    public Person convertDtoToEntity(PersonDtoV2 personDto) {
        Person person = new Person();

        person.setId(person.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setAddress(personDto.getAddress());
        person.setGender(personDto.getGender());

        return person;
    }
}
