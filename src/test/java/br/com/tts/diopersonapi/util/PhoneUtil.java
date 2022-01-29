package br.com.tts.diopersonapi.util;

import br.com.tts.diopersonapi.dto.request.PhoneDTO;
import br.com.tts.diopersonapi.entity.Phone;
import br.com.tts.diopersonapi.enums.PhoneType;

public class PhoneUtil {
    private static final Long FAKE_PHONE_ID = 1L;
    private static final PhoneType FAKE_PHONE_TYPE = PhoneType.HOME;
    private static final String FAKE_PHONE_NUMBER = "041988888888";

    public static PhoneDTO createFakePhoneDTO(){
        return PhoneDTO.builder()
                .id(FAKE_PHONE_ID)
                .type(FAKE_PHONE_TYPE)
                .number(FAKE_PHONE_NUMBER)
                .build();
    }

    public static Phone createFakePhone(){
        return Phone.builder()
                .id(FAKE_PHONE_ID)
                .type(FAKE_PHONE_TYPE)
                .number(FAKE_PHONE_NUMBER)
                .build();
    }

}
