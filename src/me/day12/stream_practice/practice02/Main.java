package me.day12.stream_practice.practice02;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "kiwi");
        String concat = words.stream().reduce((w1, w2) -> (w1 + " " + w2)).get();
        System.out.println("concat = " + concat);
    }
}
