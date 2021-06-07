package one.digitalInnovation.personaapi.utils;

import one.digitalInnovation.personaapi.dto.request.PersonDTO;
import one.digitalInnovation.personaapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Matheus";
    private static final String LAST_NAME = "Kaczan";
    private static final String CPF_NUMBER = "861.079.325-77";
    private static final long PERSON_ID = 1L;
    //public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                //.birthDate("1998-10-29")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity(){
        return Person.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                //.birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
