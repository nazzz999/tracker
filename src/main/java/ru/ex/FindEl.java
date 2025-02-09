package ru.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found: " + key);
    }

    public static void main(String[] args) throws ElementNotFoundException {
        try {
            indexOf(new String[]{"Nastya", "Irina"}, "Nasty");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
