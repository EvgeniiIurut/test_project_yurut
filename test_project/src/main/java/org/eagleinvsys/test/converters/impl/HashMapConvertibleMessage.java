package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.Map;
import java.util.Objects;

public class HashMapConvertibleMessage implements ConvertibleMessage {

    private final Map<String, String> elements;

    public HashMapConvertibleMessage(Map<String, String> elements) {
        this.elements = elements;
    }

    @Override
    public String getElement(String elementId) {
        return elements.get(elementId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMapConvertibleMessage that = (HashMapConvertibleMessage) o;
        return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}