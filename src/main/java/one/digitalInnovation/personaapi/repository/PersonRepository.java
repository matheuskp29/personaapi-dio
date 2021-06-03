package one.digitalInnovation.personaapi.repository;

import one.digitalInnovation.personaapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
