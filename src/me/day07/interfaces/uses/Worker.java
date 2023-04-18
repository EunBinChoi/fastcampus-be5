package me.day07.interfaces.uses;

public class Worker extends Person implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Worker - Renew Driver License");
    }

    @Override
    public void defaultMethod() {
        System.out.println("Worker - Default Method");
    }
}
