package me.day02.string_practice;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(sentence, " ");
        System.out.println(stringTokenizer.countTokens());

//        String[] splits = sentence.split(" ");
//        System.out.println(splits.length);

        scanner.close();
    }
}
