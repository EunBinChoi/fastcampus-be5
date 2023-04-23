package me.day09.assignment04_review.practice06;

public class Worker extends Person implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Worker - Renew Driver License");
    }
}
