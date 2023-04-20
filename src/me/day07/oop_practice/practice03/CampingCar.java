package me.day07.oop_practice.practice03;

public class CampingCar extends Car implements Sleepable {

    @Override
    public void on() {
        System.out.println("[CampingCar] POWER ON");
    }

    @Override
    public void off() {
        System.out.println("[CampingCar] POWER OFF");
    }
}
