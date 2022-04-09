package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.ConvertibleCollectionImpl;
import org.eagleinvsys.test.converters.impl.HashMapConvertibleMessage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HashMapConvertibleMessageTest {

    @Test
    void getElement() {
        // given
        Map<String, String> mapToCheck = Map.of("Name", "Bob",
                "Last name", "Dylan",
                "Age", "56");
        final ConvertibleMessage hashMapConvertibleMessage = new HashMapConvertibleMessage(mapToCheck);
        // when
        String expectedResult = mapToCheck.get("Age");
        String ageOfElement = hashMapConvertibleMessage.getElement("Age");
        // then
        assertEquals(ageOfElement, expectedResult);
    }
}