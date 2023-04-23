package me.day07.assignment04.practice06;

import me.day09.assignment04_review.practice06.DriveLicenseAble;
import me.day09.assignment04_review.practice06.Person;

public class Worker extends Person implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("Worker - Renew Driver License");
    }
}
