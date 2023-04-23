package me.day07.assignment04.practice06;

import me.day09.assignment04_review.practice06.Person;
import me.day09.assignment04_review.practice06.SaleAble;

public class Kid extends Person implements SaleAble {
    @Override
    public double rate() {
        return 1.0; // 100%
    }
}
