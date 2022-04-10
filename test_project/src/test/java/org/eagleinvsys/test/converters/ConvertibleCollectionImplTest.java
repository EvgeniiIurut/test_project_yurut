package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.ConvertibleCollectionImpl;
import org.eagleinvsys.test.converters.impl.HashMapConvertibleMessage;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ConvertibleCollectionImplTest {
    @Test
    void should_return_collection_of_headers() {
        // given List<Map> -> Collection<String>
        final var expectedResult = Set.of("Name", "Last name", "Age");
        final var elementsList = List.of(Map.of(
                "Name", "Bob",
                "Last name", "Dylan",
                "Age", "56"));
        // when
        final ConvertibleCollection convertibleCollection = new ConvertibleCollectionImpl(elementsList);
        Collection<String> expectedHeaders = convertibleCollection.getHeaders();
        // then
        assertEquals(expectedHeaders, expectedResult);
    }

    @Test
    void should_return_records() {
        // given
        final var expectedResult = List.of(new HashMapConvertibleMessage(Map.of(
                "Name", "Bob",
                "Last name", "Dylan",
                "Age", "56")));
        final var elementsList = List.of(Map.of(
                "Name", "Bob",
                "Last name", "Dylan",
                "Age", "56"));
        // when
        final ConvertibleCollection convertibleCollection = new ConvertibleCollectionImpl(elementsList);
        Iterable<ConvertibleMessage> expectedRecords = convertibleCollection.getRecords();
        // then
        assertEquals(expectedRecords, expectedResult);
    }
}