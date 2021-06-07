package one.digitalInnovation.personaapi.service;

import one.digitalInnovation.personaapi.dto.request.PersonDTO;
import one.digitalInnovation.personaapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personaapi.entity.Person;
import one.digitalInnovation.personaapi.repository.PersonRepository;
import one.digitalInnovation.personaapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalInnovation.personaapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO.builder()
                .message("Created person with ID " + id)
                .build();

    }
}
