package ru.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.printInfo();
        Item itemTwo = new Item("Nastya");
        itemTwo.printInfo();
        Item itemTree = new Item(7777, "Nastya Nazarycheva");
        itemTree.printInfo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}