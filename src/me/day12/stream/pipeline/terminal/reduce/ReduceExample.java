package me.day12.stream.pipeline.terminal.reduce;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
//        List<Person> personList = Arrays.asList(
//                new Person("kim", 30),
//                new Person("lee", 20),
//                new Person("park", 50)
//        );

        List<Person> personList = Arrays.asList();

        // sum 이용
        int sum1 = personList.stream()
                .mapToInt(Person :: getAge)
                .sum(); // 요소가 없으면 0으로 출력


        // 1, 2, 3, 4, 5
        // (0, 1) -> 1
        // (1, 2) -> 3
        // (3, 3) -> 6
        // (6, 4) -> 10
        // (10, 5) -> 15

        // reduce(BinaryOperator<Integer> ac) 이용
        int sum2 = personList.stream()
                .map(Person::getAge)
                .reduce((a, b) -> a + b)
                .orElse(0);


        // 1, 2, 3, 4, 5
        // (100, 1) -> 101
        // (101, 2) -> 103
        // (103, 3) -> 106
        // (106, 4) -> 110
        // (110, 5) -> 115

        // reduce(int identity, IntBinaryOperator op) 이용
        int sum3 = personList.stream()
                .map(Person :: getAge)
                .reduce(100, (a, b) -> a + b); // 요소가 없으면 0으로 출력


        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
        System.out.println("sum3: " + sum3);
    }
}
