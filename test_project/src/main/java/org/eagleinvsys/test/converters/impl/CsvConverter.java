package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.io.IOException;
import java.io.OutputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.joining;

public class CsvConverter implements Converter {
    /**
     * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) {
        try {
            outputStream.write(String.join(",", collectionToConvert.getHeaders()).getBytes(UTF_8));
            for (ConvertibleMessage record : collectionToConvert.getRecords()) {
                outputStream.write("\n".getBytes(UTF_8));
                final String recordAsString = collectionToConvert.getHeaders().stream().map(record::getElement).collect(joining(","));
                outputStream.write(recordAsString.getBytes(UTF_8));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}