package me.day11.assignment06.practice01;

import java.util.*;

public class Students extends ArrayList<Student>{

    public Students(int initialCapacity) {
        super(initialCapacity);
    }

    public Students() {
    }

    public Students(Collection<? extends Student> c) {
        super(c);
    }

    public void print() {
        if (super.size() == 0) {
            System.out.println("Nothing to print in array.");
            return;
        }

        for (int i = 0; i < super.size(); i++) {
            System.out.println(super.get(i));
        }
    }

}
