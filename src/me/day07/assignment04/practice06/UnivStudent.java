package me.day07.assignment04.practice06;

public class UnivStudent extends Student implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("UnivStudent - Renew Driver License");
    }
}
