package ru.poly;

public class Bus implements Transport {
    private int countPassengers;
    private final double fuelPricePerLiter = 58.0;
    private final double fuelCapacity = 100.0;
    private double currentFuel = 0.0;

    @Override
    public void drive() {
        if (currentFuel > 0) {
            System.out.println("Автобус едет с " + countPassengers + " пассажирами.");
            currentFuel -= 1; // Уменьшаем количество топлива при движении
        } else {
            System.out.println("Недостаточно топлива для движения!");
        }
    }

    @Override
    public void passengers(int passengers) {
        if (passengers <= 25) {
            this.countPassengers = passengers;
            System.out.println("Количество пассажиров в автобусе: " + countPassengers);
        } else {
            System.out.println("Слишком много пассажиров! Максимум: 25.");
        }
    }

    @Override
    public int refuel(int fuel) {
        if (fuel + currentFuel <= fuelCapacity) {
            currentFuel += fuel;
            double cost = fuel * fuelPricePerLiter;
            System.out.println("Заправлено " + fuel + " литров. Стоимость: " + cost);
        } else {
            System.out.println("Слишком много топлива! Максимальная ёмкость: " + fuelCapacity);
        }
        return 0;
    }
}

