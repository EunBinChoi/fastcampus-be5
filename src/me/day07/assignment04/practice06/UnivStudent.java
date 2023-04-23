package me.day07.assignment04.practice06;

import me.day09.assignment04_review.practice06.DriveLicenseAble;
import me.day09.assignment04_review.practice06.Student;

public class UnivStudent extends Student implements DriveLicenseAble {
    @Override
    public void renew() {
        System.out.println("UnivStudent - Renew Driver License");
    }
}
