package me.day02.string_practice;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("message : ");
        String message = scanner.nextLine().toUpperCase();
        String newMessage = "";

        for (int i = 0; i < message.length(); i++) {

            if (i == 0 || message.charAt(i-1) == ' ') { // i가 단어의 첫 문자
                newMessage += (char)(message.charAt(i) + ('a' - 'A'));
                // 문자 => 아스키코드
                // 문자끼리 사칙연산 => 정수끼리 사칙연산
                // byte + byte => int
                // char (정수형) + char (정수형) => int
            } else {
                newMessage += message.charAt(i);
            }
        }
        System.out.println(newMessage);
        scanner.close();
    }
}
