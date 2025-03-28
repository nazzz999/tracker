package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String rightElement = right.split("/")[0];
        String leftElement = left.split("/")[0];
        return rightElement.compareTo(leftElement) == 0 ? left.compareTo(right) : rightElement.compareTo(leftElement);
    }
}