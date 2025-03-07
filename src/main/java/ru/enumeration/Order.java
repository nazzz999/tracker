package ru.enumeration;

public class Order {
    private int number;
    private String car;
    private Status status;

    public Order(int number, String car, Status status) {
        this.number = number;
        this.car = car;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
