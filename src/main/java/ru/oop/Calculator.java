package ru.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int num) {
        return sum(num) + multiply(num) + minus(num) + divide(num);
    }

    public static void main(String[] args) {
        System.out.println("Сложение: " + sum(10));
        Calculator calculator = new Calculator();
        System.out.println("Умножение: " + calculator.multiply(10));
        System.out.println("Вычитание: " + minus(10));
        System.out.println("Деление: " + calculator.divide(10));
        System.out.println("Результат всех действий: " + calculator.sumAllOperation(10));
    }
}
