package me.day01.operator;

import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x?");
        int x = scanner.nextInt();

        System.out.print("y?");
        int y = scanner.nextInt();

        if (x == y) {
            System.out.println("x, y를 비교할 수 없습니다.");
            return; // main 함수 종료
        }

        int max = Math.max(x, y);
        int min = Math.min(x, y);


    }
}
