package ru.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        fox.tryEat(ball);
        wolf.tryEat(ball);
        hare.tryEat(ball);
    }
}
