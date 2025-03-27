package ru.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> allDepartments = new LinkedHashSet<>();
        for (String department : departments) {
            String[] splitDepartment = department.split("/");
            StringBuilder currentDepartment = new StringBuilder();
            for (int i = 0; i < splitDepartment.length; i++) {
                if (i > 0) {
                    currentDepartment.append("/");
                }
                currentDepartment.append(splitDepartment[i]);
                allDepartments.add(currentDepartment.toString());
            }
        }
        return new ArrayList<>(allDepartments);
    }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments);
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
