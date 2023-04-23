package me.day09.assignment04_review.practice06;

public class Student extends Person implements SaleAble {
    @Override
    public double rate() {
        return 0.3; // 30%
    }
}
