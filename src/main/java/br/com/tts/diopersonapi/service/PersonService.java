package br.com.tts.diopersonapi.service;

import br.com.tts.diopersonapi.dto.MessageResponseDTO;
import br.com.tts.diopersonapi.dto.request.PersonDTO;
import br.com.tts.diopersonapi.entity.Person;
import br.com.tts.diopersonapi.exception.PersonNotFoundException;
import br.com.tts.diopersonapi.mapper.PersonMapper;
import br.com.tts.diopersonapi.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    private static  final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);
        Person createPerson = personRepository.save(personToSave);

        return createMessageResponse("Created person with ID", createPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatePerson = personRepository.save(personToUpdate);
        return createMessageResponse("Updated person with ID", updatePerson.getId());

    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String message, Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + " " + id)
                .build();
    }

}
