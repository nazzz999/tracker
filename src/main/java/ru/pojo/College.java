package ru.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Nazarycheva Anastasia Alekseevna");
        student.setGroup("22-IST");
        student.setEntrance(LocalDate.now());
        System.out.println(student.getName() + " " + student.getGroup() + " " + student.getEntrance());
    }
}
