package me.day07.assignment04.practice06;

public class Worker extends Person implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Worker - Renew Driver License");
    }
}
