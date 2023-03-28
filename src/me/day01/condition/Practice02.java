package me.day01.condition;

import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문자를 받는 방법
        char letter = (char)scanner.nextInt();

        // abcd => a
        // a => a
        String letter2 = scanner.next();
        if (letter2.length() > 1) {
            System.out.println("문자열이야,, 이놈아,,");
        }

        System.out.println("letter = " + letter);
    }
}
