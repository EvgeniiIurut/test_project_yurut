package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.ConvertibleCollectionImpl;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.eagleinvsys.test.converters.impl.HashMapConvertibleMessage;
import org.eagleinvsys.test.converters.impl.StandardCsvConverter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class StandardCsvConverterTests {
    // TODO: implement JUnit 5 tests for StandardCsvConverter
    @Test
    void should_convert_standart_collection_to_csv() {
        // given
        CsvConverter mock = mock(CsvConverter.class);
        final var standardCsvConverter = new StandardCsvConverter(mock);
        List<Map<String, String>> inputCollection = List.of(Map.of(
                "Name", "Bob",
                "Last name", "Dylan",
                "Age", "56"));
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // when
        standardCsvConverter.convert(inputCollection, outputStream);
        // then
        verify(mock)
                .convert(new ConvertibleCollectionImpl(inputCollection), outputStream);
    }
}