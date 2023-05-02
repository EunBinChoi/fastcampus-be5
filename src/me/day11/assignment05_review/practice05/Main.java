package me.day11.assignment05_review.practice05;

import me.day09.assignment05.practice05.Clazz;
import me.day09.assignment05.practice05.Person;

public class Main {
    public static void main(String[] args) {
        Clazz clazz1 = new Clazz(10, "abc",
                new Person[] {
                        new Person("a", Person.Gender.MALE, "19880101", "19880101-1234567"),
                        new Person("b", Person.Gender.FEMALE, "19900320", "19900320-2345678"),
                        new Person("c", Person.Gender.FEMALE, "19960830", "19960830-2012020")});
        Clazz clazz2 = null;
        try {
            clazz2 = clazz1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("주소값 비교 = " + (clazz1 == clazz2));
        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println();
        System.out.println("배열 주소값 비교 = " + (clazz1.getPersonArray() == clazz2.getPersonArray()));
        System.out.println("객체 주소값 비교 = " + (clazz1.getPersonArray()[0] == clazz2.getPersonArray()[0]));

        // 원소값 수정
        clazz1.getPersonArray()[0].setName("d");
        System.out.println(clazz1.getPersonArray()[0]);
        System.out.println(clazz2.getPersonArray()[0]);
        System.out.println();

    }
}
