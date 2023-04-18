package me.day07.oop_refactor.practice03;

public interface Driveable {
    default void on() {
        System.out.println("POWER ON");
    }
    default void off() {
        System.out.println("POWER OFF");
    }
}
