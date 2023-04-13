package me.day02.string;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        // 상수가 뒤집어서 읽음

        Scanner scanner = new Scanner(System.in);
        String str1 = new StringBuilder(scanner.next()).reverse().toString();
        String str2 = new StringBuilder(scanner.next()).reverse().toString();
        String answer = str1.compareTo(str2) > 0 ? str1 : str2;
        System.out.println(answer);

        scanner.close();
    }
}
