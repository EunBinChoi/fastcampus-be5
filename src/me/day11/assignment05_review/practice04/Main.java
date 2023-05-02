package me.day11.assignment05_review.practice04;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final int NUM = 5;
        Person[] people = new Person[NUM];

        people[0] = new Person("bb", Person.Gender.MALE, "881010", "881010-1112345");
        people[1] = new Person("aa", Person.Gender.MALE, "990320", "990320-1354290");
        people[2] = new Person("ee", Person.Gender.FEMALE, "970708", "970708-2533921");
        people[3] = new Person("aa", Person.Gender.FEMALE, "970722", "970722-2387883");
        people[4] = new Person("zz", Person.Gender.MALE, "980420", "980420-1101225");

        // stable 정렬 (정렬하려고 하는 기준 필드가 @Nullable이 아닌지 확인)
        System.out.println("<이름 오름차순 정렬 (people 배열에 이름이 null인 친구는 없다)>");
        Arrays.sort(people);
        for (Person p: people) {
            System.out.println(p);
        }
    }
}
