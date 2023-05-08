package me.day12.stream_practice.practice02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    List<String> words = Arrays.asList("banana", "apple", "kiwi");
    public String join() {
        return words.stream().collect(Collectors.joining());
    }
    public static void main(String[] args) {
        String concat = new Main().join();
        System.out.println(concat);
    }
}
