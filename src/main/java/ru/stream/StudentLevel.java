package ru.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .dropWhile(student -> student.getScore() < bound)
                .sorted((left, right) -> right.getScore() - left.getScore())
                .map(student -> new Student(student.getScore(), student.getSurname()))
                .collect(Collectors.toList());
    }
}
