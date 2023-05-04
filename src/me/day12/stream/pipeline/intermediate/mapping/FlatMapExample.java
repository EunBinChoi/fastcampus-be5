package me.day12.stream.pipeline.intermediate.mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        // 입력된 데이터 (요소)들이 List<String>에 저장되어 있다고 가정하고 요소별로 단어를 뽑아 단어 스트림으로 재생성
        // 입력된 데이터들이 숫자라면 숫자를 뽑아 숫자 스트림으로 재생성할 수 있음
        List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
        List<String> inputListResult1 = inputList1.stream()
                .flatMap(data -> Arrays.stream(data.split(" "))) // ["java8", "lambda"], ["stream", "mapping"]
                .collect(Collectors.toList());
        System.out.println(inputListResult1);
        System.out.println();


        List<String> inputList2 = Arrays.asList("10,20,30", "40,50,60");
        inputList2.stream().forEach(System.out::println);

        Stream<String> stream = inputList2.stream();
        stream.forEach(System.out::println);

        // Collection => Stream => Operated..
        // Collection => Stream

        List<Integer> inputListResult2 = inputList2.stream()
                .flatMap(data -> Arrays.stream(data.split(","))) // ["10", "20", "30", "40", "50", "60"]
                .map(Integer::valueOf) // [10, 20, 30, 40, 50, 60]
                .collect(Collectors.toList());
        System.out.println(inputListResult2);
    }
}