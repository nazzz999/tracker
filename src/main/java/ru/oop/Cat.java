package ru.oop;

public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.println(this.name + " eat " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There is gav's food");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There is black's food.");
        Cat black = new Cat();
        black.giveNick("Bob");
        black.eat("fish");
        black.show();
    }
}
