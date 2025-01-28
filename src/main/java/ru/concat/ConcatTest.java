package ru.concat;

public class ConcatTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuilder str = new StringBuilder("Java");
        for (int index = 0; index < 9999; index++) {
            str.append(index);
        }
        System.out.println("Миллисекунд: " + (System.currentTimeMillis() - startTime));
    }
}
