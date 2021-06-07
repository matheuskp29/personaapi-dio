package one.digitalInnovation.personaapi.service;

import one.digitalInnovation.personaapi.dto.request.PersonDTO;
import one.digitalInnovation.personaapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personaapi.entity.Person;
import one.digitalInnovation.personaapi.mapper.PersonMapper;
import one.digitalInnovation.personaapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
