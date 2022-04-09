package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertibleCollectionImpl implements ConvertibleCollection {
    private final List<Map<String, String>> elementsList;

    public ConvertibleCollectionImpl(List<Map<String, String>> elementsList) {
        this.elementsList = elementsList;
    }

    @Override
    public Collection<String> getHeaders() {
        return elementsList.stream().map(Map::keySet).flatMap(Collection::stream).collect(Collectors.toSet());
    }

    @Override
    public Iterable<ConvertibleMessage> getRecords() {
        return elementsList.stream().map(HashMapConvertibleMessage::new).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConvertibleCollectionImpl that = (ConvertibleCollectionImpl) o;
        return Objects.equals(elementsList, that.elementsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementsList);
    }
}
