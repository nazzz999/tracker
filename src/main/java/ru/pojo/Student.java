package ru.pojo;

import java.time.LocalDate;

public class Student {
    private String name;
    private String group;
    private LocalDate entrance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getEntrance() {
        return entrance;
    }

    public void setEntrance(LocalDate entrance) {
        this.entrance = entrance;
    }
}
