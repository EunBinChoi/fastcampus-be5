package me.day04;

import java.util.Scanner;

public class Practice06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next().toLowerCase();

        int[] counts = new int['z' - 'a' + 1]; // 'a' <=    <= 'z'
        char[] alpha = new char['z' - 'a' + 1]; // 'a' <=    <= 'z'

        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = (char)('a' + i);
        }

        // a b c d e f g h .... z
        // 0 1 2 3 ............ 25
        // 4 1 0 0 ............ 0

        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'a']++;
        }

        int max = -1;
        String popular = "";
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                popular = Character.toString(alpha[i]).toUpperCase();
            } else if (counts[i] == max) {
                popular = "?";
            }
        }

        System.out.println(popular);

        scanner.close();

    }
}
