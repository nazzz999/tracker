package ru.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, -3, -7, 0);
        List<Integer> positive = numbers.stream().filter(
                number -> number > 0
        ).toList();
        positive.forEach(System.out::println);
    }
}

