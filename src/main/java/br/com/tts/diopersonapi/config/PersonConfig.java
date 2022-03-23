package br.com.tts.diopersonapi.config;

import br.com.tts.diopersonapi.entity.Person;
import br.com.tts.diopersonapi.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository){
        return args -> {
            Person person1 = Person.builder()
                    .id(1L)
                    .firstName("Tiago")
                    .lastName("Fernandes")
                    .cpf("03425757911")
                    .build();

            Person person2 = Person.builder()
                    .id(2L)
                    .firstName("Cheila")
                    .lastName("Costa")
                    .cpf("01892508958")
                    .build();

            personRepository.saveAll(List.of(person1, person2));
        };
    }

}
