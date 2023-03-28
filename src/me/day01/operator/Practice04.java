package me.day01.operator;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int num = scanner.nextInt();
        String signAnswer = (num == 0) ? "0" : ((num > 0) ? "양수" : "음수");
        System.out.printf("숫자 %d은 [%s] 입니다.\n", num, signAnswer);

        scanner.close();
    }
}
