package org.eagleinvsys.test;

import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.Map;

public class TestonvertiableMessage implements ConvertibleMessage {


    private final Map<String, String> elements;

    public TestonvertiableMessage(Map<String, String> elements) {
        this.elements = elements;
    }

    @Override
    public String getElement(String elementId) {
        return elements.get(elementId);
    }
}
