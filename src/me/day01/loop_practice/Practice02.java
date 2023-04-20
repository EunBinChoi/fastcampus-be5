package me.day01.loop_practice;

import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String answer = "";
//        while (true) {
//            char ch = scanner.next().charAt(0);
//            if (ch == 'q') break; // 종료구문은 항상 위에 작성하는 게 좋음
//
//            answer = ch + answer;
//        }
//        System.out.println("answer = " + answer);

        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            char ch = scanner.next().charAt(0);
            if (ch == 'q') break;

            stringBuilder.insert(0, ch);
        }
        String answer = stringBuilder.toString();
        System.out.println("answer = " + answer);


        scanner.close();
    }
}