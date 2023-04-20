package me.day07.oop_practice.practice02;

public interface Drawable {
    default void draw() {
        System.out.println("draw()");
    }
}
