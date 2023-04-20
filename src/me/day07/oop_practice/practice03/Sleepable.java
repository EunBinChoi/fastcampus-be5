package me.day07.oop_practice.practice03;

public interface Sleepable {
    default void on() {
        System.out.println("POWER ON");
    }
    default void off() {
        System.out.println("POWER OFF");
    }
    default void foldSeat() {
        System.out.println("FOLD SEATS");
    }
    default void unfoldSeat() {
        System.out.println("UNFOLD SEATS");
    }
}
