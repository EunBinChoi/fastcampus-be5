package me.day12.stream.pipeline.intermediate.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
    private String lastName;
    private Integer age;

    public Person() {
    }

    public Person(String lastName, Integer age) {
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Person='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

class NonException extends RuntimeException {
    public NonException() {
    }

    public NonException(String message) {
        super(message);
    }
}

public class MapExample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        // 사람의 나이를 요소로 하는 새로운 스트림을 생성하고 나이를 출력
        personList.stream()
                .mapToInt(Person::getAge)
                .forEach(System.out::println);

        // 사람의 나이를 요소로 하는 새로운 스트림을 생성하고 평균 나이 계산
        double average = personList.stream()
                .mapToInt(Person::getAge)
                .average().orElseThrow(() -> {throw new NonException();});
        System.out.println("평균 나이 = " + average);


    }
}