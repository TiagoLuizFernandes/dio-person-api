package br.com.tts.diopersonapi.controller;

import br.com.tts.diopersonapi.dto.MessageResponseDto;
import br.com.tts.diopersonapi.dto.request.PersonDTO;
import br.com.tts.diopersonapi.exception.PersonNotFoundException;
import br.com.tts.diopersonapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){

        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody @Valid PersonDTO personDto) {
        return personService.createPerson(personDto);
    }

    @GetMapping
    public List<PersonDTO> listAll(){

        return personService.listAll();

    }

    @GetMapping(path = "{id}")
    public PersonDTO findById(@PathVariable("id") Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

}
