package me.day07.assignment04.practice06;

public class Student extends Person implements SaleAble {
    @Override
    public double rate() {
        return 0.3; // 30%
    }
}
