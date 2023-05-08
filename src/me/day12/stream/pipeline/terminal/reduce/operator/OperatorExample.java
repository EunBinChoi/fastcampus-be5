package me.day12.stream.pipeline.terminal.reduce.operator;

import me.day12.stream.pipeline.overview.Person;

import java.util.ArrayList;
import java.util.List;

public class OperatorExample {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        
        // NoSuchElementException 발생
//        int sum = personList.stream()
//                .map(Person::getAge)
//                .reduce((a, b) -> (a + b))
//                .get();
//        System.out.println("sum = " + sum);

        // NoSuchElementException 발생하지 않음
        // 디폴트 값인 0 리턴
        int sum = personList.stream()
                .map(Person::getAge).reduce(0, (a, b) -> (a + b));

        // a  b
        // 0, a  => a
        // a  b  => a + b
        // a+b c => a + b+ c
        System.out.println("sum = " + sum);
    }
}
