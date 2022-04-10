package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.HashMapConvertibleMessage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HashMapConvertibleMessageTest {
    @Test
    void should_return_null_when_value_does_not_exist() {
        // given
        Map<String, String> mapToCheck = new HashMap<>();
        mapToCheck.put("Name", "Bob");
        mapToCheck.put("Last name", "Dylan");
        mapToCheck.put("Age", null);
        final ConvertibleMessage hashMapConvertibleMessage = new HashMapConvertibleMessage(mapToCheck);
        // when
        String ageOfElement = hashMapConvertibleMessage.getElement("Age");
        // then
        assertNull(ageOfElement);
        assertEquals(hashMapConvertibleMessage.getElement("Name"), "Bob");
        assertEquals(hashMapConvertibleMessage.getElement("Last name"), "Dylan");
    }
}