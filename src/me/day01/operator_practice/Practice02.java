package me.day01.operator_practice;

import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int x = scanner.nextInt();

        System.out.print("정수 입력 : ");
        int y = scanner.nextInt();

        int min = Math.min(x, y);
        int max = Math.max(x, y);
        System.out.println("\n>> 최솟값 : " + min);
        System.out.println(">> 최댓값 : " + max);

        scanner.close();
    }
}