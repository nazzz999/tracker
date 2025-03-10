package ru.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("nastya@gmail.com", "Nazarycheva Anastasia Alekseevna");
        map.put("sergey.sharov@gmail.com", "Sharov Sergey Mikhailovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
