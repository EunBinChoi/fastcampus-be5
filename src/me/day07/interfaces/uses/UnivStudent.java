package me.day07.interfaces.uses;

public class UnivStudent extends Person implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("UnivStudent - Renew Driver License");
    }

    static void staticMethod() {
        System.out.println("UnivStudent - Static Method");
    }
}
