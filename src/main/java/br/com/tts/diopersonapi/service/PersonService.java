package br.com.tts.diopersonapi.service;

import br.com.tts.diopersonapi.dto.MessageResponseDto;
import br.com.tts.diopersonapi.dto.request.PersonDTO;
import br.com.tts.diopersonapi.entity.Person;
import br.com.tts.diopersonapi.mapper.PersonMapper;
import br.com.tts.diopersonapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
