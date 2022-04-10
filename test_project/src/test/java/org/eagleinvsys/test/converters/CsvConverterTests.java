package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.eagleinvsys.test.converters.impl.HashMapConvertibleMessage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class CsvConverterTests {
    @Test
    void should_convert_collection_to_csv() {
        // given
        final var expectedResult = "Name,Last name,Age\n" +
                "Bob,Dylan,";
        final var headers = List.of("Name", "Last name", "Age");
        Map<String, String> mapToCheck = new HashMap<>();
        mapToCheck.put("Name", "Bob");
        mapToCheck.put("Last name", "Dylan");
        mapToCheck.put("Age", null);
        final HashMapConvertibleMessage message = new HashMapConvertibleMessage(mapToCheck);

        final ConvertibleCollection collection = Mockito.mock(ConvertibleCollection.class);
        when(collection.getRecords()).thenReturn(List.of(message));
        when(collection.getHeaders()).thenReturn(headers);
        final CsvConverter csvConverter = new CsvConverter();

        // when
        final var outputStream = new ByteArrayOutputStream();
        csvConverter.convert(collection, outputStream);

        // then
        assertThat(outputStream.toString()).isEqualTo(expectedResult);
    }
}