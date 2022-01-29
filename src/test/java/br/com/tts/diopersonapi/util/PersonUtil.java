package br.com.tts.diopersonapi.util;

import br.com.tts.diopersonapi.dto.request.PersonDTO;
import br.com.tts.diopersonapi.entity.Person;

import java.time.LocalDate;
import java.util.Arrays;

public class PersonUtil {
    private static Long FAKE_PERSON_ID = 1L;
    private static String FAKE_FIRST_NAME = "Thyago";
    private static String FAKE_LAST_NAME = "Luys Fernandez";
    private static String FAKE_CPF = "02125874199";
    private static LocalDate FAKE_BIRTH_DATE = LocalDate.of(1981,01,01);
    private static String FAKE_BIRTH_DATE_S = "01-01-1981";

    public static PersonDTO createFakePersonDTO(){
        return PersonDTO.builder()
                .id(FAKE_PERSON_ID)
                .firstName(FAKE_FIRST_NAME)
                .lastName(FAKE_LAST_NAME)
                .cpf(FAKE_CPF)
                .birthDate(FAKE_BIRTH_DATE_S)
                .phones(Arrays.asList(PhoneUtil.createFakePhoneDTO()))
                .build();
    }

    public static Person createFakePerson(){
        return Person.builder()
                .id(FAKE_PERSON_ID)
                .firstName(FAKE_FIRST_NAME)
                .lastName(FAKE_LAST_NAME)
                .cpf(FAKE_CPF)
                .birthDate(FAKE_BIRTH_DATE)
                .phones(Arrays.asList(PhoneUtil.createFakePhone()))
                .build();
    }

}
