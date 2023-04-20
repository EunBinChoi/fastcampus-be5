package me.day01.operator_practice;

import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("연도 입력 : ");
        int year = scanner.nextInt();
        String leapYearAnswer = (year %  4 == 0 && year % 100 != 0) || (year % 400 == 0) ? "윤년" : "평년";
        System.out.printf("%d 년은 [%s] 입니다.\n", year, leapYearAnswer);

        scanner.close();
    }
}