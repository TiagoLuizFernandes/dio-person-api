package br.com.tts.diopersonapi.service;

import br.com.tts.diopersonapi.dto.MessageResponseDTO;
import br.com.tts.diopersonapi.dto.request.PersonDTO;
import br.com.tts.diopersonapi.entity.Person;
import br.com.tts.diopersonapi.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.tts.diopersonapi.util.PersonUtil.createFakePerson;
import static br.com.tts.diopersonapi.util.PersonUtil.createFakePersonDTO;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiveTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakePersonDTO();
        Person expectedSavedPerson = createFakePerson();

        when(personRepository.save(expectedSavedPerson)).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedMessage = createMessageResponseDTO("Created person with ID",expectedSavedPerson.getId());

        MessageResponseDTO messageResponseDTO = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedMessage,messageResponseDTO);
    }

    private MessageResponseDTO createMessageResponseDTO(String message, Long id) {
        return MessageResponseDTO
                .builder()
                .message( message + " " + id).build();
    }

}
