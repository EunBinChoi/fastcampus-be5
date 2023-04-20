package me.day04.array_practice;

import java.util.Scanner;

public class Practice06 { // 알파벳 ('a'~'z': 26 letters) 'a' <= x <= 'z'
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next().toLowerCase(); // 소문자로 일괄적으로 변경

        int[] counts = new int['z' - 'a' + 1]; // 'a' <=    <= 'z'
        char[] alpha = new char['z' - 'a' + 1]; // 'a' <=    <= 'z'

        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = (char)('a' + i);
        }

        // count 0-25: {1, 0, 0, .... 2}
        // alpha 0-25: 'a'~'z'

        // 0-25 (index): 순서가 존재하는 데이터
        // 'a'-'z' (alpha): 순서가 존재하는 데이터
        // 'a' => 0
        // 'z' => 25
        // 'z'-'a' => 25
        // 'a'-'a' => 0

        for (int i = 0; i < word.length(); i++) { // c
            counts[word.charAt(i) - 'a']++; // 2
        }

        // "abb"
        // count: {1, 2, .......}
        // alpha: {'a', 'b' ... 'z'}
        int max = -1; // counts (>= 0)
        char popular = '\0';
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                popular = (char)(alpha[i] - ('a' - 'A'));
            } else if (counts[i] == max) {
                popular = '?';
            }
        }

        System.out.println(popular);
        scanner.close();

    }
}
