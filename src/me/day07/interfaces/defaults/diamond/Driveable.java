package me.day07.interfaces.defaults.diamond;

public interface Driveable {
    default void on() {
        System.out.println("POWER ON");
    }
    default void off() {
        System.out.println("POWER OFF");
    }
}
