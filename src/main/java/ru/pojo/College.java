package ru.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Nazarycheva Anastasia Alekseevna");
        student.setGrup("22-IST");
        student.setEntrance(new Date());
        System.out.println(student.getName() + " " + student.getGrup() + " " + student.getEntrance());
    }
}
