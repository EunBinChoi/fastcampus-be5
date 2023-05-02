package me.day11.assignment06.practice03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {

        studentList.add(new Student("20212222", "이순신", 85)); // 입학연도: 2021 + 들어간 순서: 1
        studentList.add(new Student("20211111", "자바킹", 100)); // 입학연도: 2021 + 들어간 순서: 2
        studentList.add(new Student("20213333", "이제이", 50)); // 입학연도: 2021 + 들어간 순서: 3
        studentList.add(new Student("20171234", "이텔리", 80)); // 입학연도: 2017 + 들어간 순서: 4
        studentList.add(new Student("20045555", "이초잉", 70)); // 입학연도: 2004 + 들어간 순서: 5


        List<Student> upperList = upper(70); // 70점 초과인 학생 집합
        System.out.println("upperList = " + upperList);

        List<Student> lowerList = lower(80); // 80점 미만인 학생 집합
        System.out.println("lowerList = " + lowerList);

        double average = average();
        System.out.println("average = " + average);
    }
    public static List<Student> upper(int score) {
        return null;
    }
    public static List<Student> lower(int score) {
        return null;
    }
    public static Double average() {
        return 0.0;
    }
}
