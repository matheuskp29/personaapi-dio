package one.digitalInnovation.personaapi.utils;

import one.digitalInnovation.personaapi.dto.request.PhoneDTO;
import one.digitalInnovation.personaapi.entity.Phone;
import one.digitalInnovation.personaapi.enums.PhoneType;

public class PhoneUtils {

    public static final String PHONE_NUMBER = "1199999-9999";
    public static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    public static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO(){
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity(){
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
