package br.com.tts.diopersonapi.repository;

import br.com.tts.diopersonapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}