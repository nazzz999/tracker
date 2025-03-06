package ru.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> tasks) {
        HashSet<String> tasksNumbers = new HashSet<>();
        for (Task task : tasks) {
            tasksNumbers.add(task.getNumber());
        }
        return tasksNumbers;
    }
}
