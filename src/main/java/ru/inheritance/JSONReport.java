package ru.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        String lineSeparator = System.lineSeparator();
        return "{" + lineSeparator
                + "\t\"name\" : " + "\"" + name + "\"," + lineSeparator
                + "\t\"body\" : " + "\"" + body + "\"" + lineSeparator
                + "}";
    }
}
