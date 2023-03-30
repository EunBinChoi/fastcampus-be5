package me.day01.condition;

import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("영문자 하나를 입력하시오: ");
        char ch = scanner.next().charAt(0); // "a" -> 'a'

        // 영문자가 아님 a ~ z, A ~ Z
        if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
            System.out.println("입력하신 문자 " + ch + " 가 유효하지 않습니다.");
            return;
        }

        // 소문자라면 대문자로 변경하는 프로그램
        // 소문자 -> 대문자 (- ('a' - 'A'))
        // 대문자 -> 대문자 (아무런 작업이 필요없음)
        if ((ch >= 'a' && ch <= 'z')) {
            ch -= ('a' - 'A');
        }
        System.out.println("결과 문자는 " + ch + " 입니다.");

        scanner.close();
    }
}