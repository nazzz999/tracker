package ru.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            Character element = evenElements.pollFirst();
            if (element != null && i % 2 == 0) {
                stringBuilder.append(element);
            }
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            Character element = descendingElements.pollLast();
            if (element != null) {
                stringBuilder.append(element);
            }
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
