package me.day14.assignment06_review.practice03;

import me.day11.assignment06.practice03.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        return studentList.stream()
                .filter(s -> s.getScore() > score)
                //.sorted((o1, o2) -> o1.getScore().compareTo(o2.getScore()))
                .sorted(Comparator.comparing(Student::getScore))
                .collect(Collectors.toList());
    }
    public static List<Student> lower(int score) {
        return studentList.stream()
                .filter(s -> s.getScore() < score)
                //.sorted((o1, o2) -> o1.getScore().compareTo(o2.getScore()) * -1)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .collect(Collectors.toList());
    }
    public static double average() {
        return studentList.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0);
    }
}
