package me.day01.condition_practice;

import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 3 + 5
        System.out.print("연산식을 입력하시오 : ");
        char x = scanner.next().charAt(0);
        char op = scanner.next().charAt(0);
        char y = scanner.next().charAt(0);


        if (!(x >= '0' && x <= '9')) {
            System.out.println(x + "가 한자리 피연산자가 아닙니다!");
            return;
        }

        if (!(op == '+' || op == '-' || op == '*' || op == '/' || op == '%')) {
            System.out.println(op + "가 유효하지 않은 연산자 입니다.");
            return;
        }

        if (!(y >= '0' && y <= '9')) {
            System.out.println(y + "가 한자리 피연산자가 아닙니다!");
            return;
        }


        // '0' <= x, y <= '9'
        // (op == '+' || op == '-' || op == '*' || op == '/' || op == '%')
        int xi = x - '0';
        // '0' ~ '9' == 48 ~ 57 (아스키코드 범위)

        // '9' - '0' = 57 - 48 = 9
        // '8' - '0' = 56 - 48 = 8
        // '5' - '0' = 53 - 48 = 5

        int yi = y - '0';
        double res = 0;

        if (op == '+') {
            res = xi + yi;
        } else if (op == '-') {
            res = xi - yi;
        } else if (op == '*') {
            res = xi * yi;
        } else if (op == '/') {
            res = xi / (double) yi;
        } else { // op == '%'
            res = xi % yi;
        }

        System.out.printf("%d %c %d = %.2f\n", xi, op, yi, res);

        scanner.close();
    }
}