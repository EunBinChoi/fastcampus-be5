package me.day07.oop_refactor.practice02;

public interface Drawable {
    default void draw() {
        System.out.println("draw()");
    }
}
