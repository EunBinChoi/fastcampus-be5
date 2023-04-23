package me.day09.assignment04_review.practice06;

public class UnivStudent extends Student implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("UnivStudent - Renew Driver License");
    }
}
