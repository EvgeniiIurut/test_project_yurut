package org.eagleinvsys.test.converters;

import org.assertj.core.api.Assertions;
import org.eagleinvsys.test.TestonvertiableMessage;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class StandardCsvConverterTests {

    // TODO: implement JUnit 5 tests for StandardCsvConverter

    @Test
    void should_convert_collection_to_csv() {
        // given
        final var expectedResult = "Name,Last name,Age\n" +
                "Bob,Dylan,56";
        final var headers = List.of("Name", "Last name", "Age");
        final TestonvertiableMessage message = new TestonvertiableMessage(Map.of(
                "Name", "Bob",
                "Last name", "Dylan",
                "Age", "56"));
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