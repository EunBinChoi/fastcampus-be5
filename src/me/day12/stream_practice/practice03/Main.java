package me.day12.stream_practice.practice03;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("홍현희", Student.Gender.FEMALE, Student.Grade.SENIOR));
        students.add(new Student("제이쓴", Student.Gender.MALE, Student.Grade.SENIOR));
        students.add(new Student("김이나", Student.Gender.FEMALE, Student.Grade.JUNIOR));

        // Grade SENIOR인 객체만 필터링해서 컬렉션 `List`에 저장하는 스트림
        List<Student> seniorList = students.stream()
                .filter(student -> student.getGrade() == Student.Grade.SENIOR)
                .collect(Collectors.toList());
        System.out.println("seniorList = " + seniorList);


        // Gender가 MALE인 객체만 필터링해서 컬렉션 `List`에 저장하는 스트림
        List<Student> maleList = students.stream()
                .filter(student -> student.getGender() == Student.Gender.MALE)
                .collect(Collectors.toList());
        System.out.println("maleList = " + maleList);


        // 현재 리스트 `students`에 저장된 성별을 컬렉션 `Set`에 저장하는 스트림
        Set<Student.Gender> genderSet = students.stream()
                .map(Student::getGender)
                .collect(Collectors.toSet());
        System.out.println("genderSet = " + genderSet);
    }
}
