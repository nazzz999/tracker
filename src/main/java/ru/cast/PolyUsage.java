package ru.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plane = new Plane();

        Vehicle[] vehicles = new Vehicle[]{bus, train, plane};
        for (Vehicle v: vehicles) {
            v.move();
        }
    }
}
