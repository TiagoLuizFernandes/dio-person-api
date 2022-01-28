package br.com.tts.diopersonapi.service;

import br.com.tts.diopersonapi.dto.MessageResponseDto;
import br.com.tts.diopersonapi.dto.request.PersonDTO;
import br.com.tts.diopersonapi.entity.Person;
import br.com.tts.diopersonapi.exception.PersonNotFoundException;
import br.com.tts.diopersonapi.mapper.PersonMapper;
import br.com.tts.diopersonapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){

        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(PersonDTO personDto) {

        Person personToSave = personMapper.toModel(personDto);

        Person createPerson = personRepository.save(personToSave);
        return MessageResponseDto
                .builder()
                .message("Created person with ID " + createPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

        Person Person = personRepository.findById(id).orElseThrow(throw new PersonNotFoundException(id));

        return personMapper.toDTO(Person);
    }

}
