package me.day12.stream_practice.practice01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    List<String> words = Arrays.asList("banana", "apple", "kiwi");
    public String longest() {
        return words.stream().reduce((s1, s2) -> (s1.length() > s2.length() ? s1 : s2)).orElse("");
    }

    public static void main(String[] args) {
        String str = new Main().longest();
        System.out.println(str);
    }
}
