package br.com.tts.diopersonapi.controller;

import br.com.tts.diopersonapi.dto.MessageResponseDto;
import br.com.tts.diopersonapi.entity.Person;
import br.com.tts.diopersonapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDto createPerson(@RequestBody  Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDto
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

}
