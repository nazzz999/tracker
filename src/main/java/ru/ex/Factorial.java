package ru.ex;

public class Factorial {
    public int calc(int number) {
        int result = 1;
        if (number < 0) {
            throw new IllegalArgumentException("Сообщение об ошибке");
        }
        for (int index = 2; index <= number; index++) {
            result *= index;
        }
        return result;
    }

    public static void main(String[] args) {
        new Factorial().calc(-1);
    }
}
