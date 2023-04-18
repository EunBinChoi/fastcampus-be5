package me.day07.assignment04.practice03;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();
        System.out.println(shape);

        Circle circle = (Circle) new Shape();
        System.out.println(circle.getCenter());
        System.out.println(circle.getRadius());
    }
}
