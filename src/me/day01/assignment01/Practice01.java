package me.day01.assignment01;

public class Practice01 {
    public static void main(String[] args) {
        ////////////////////////////////////////
        // for 문 형태

        // 1. 횟수 기반 (10 - 0 => 10번 반복하겠다.)
        for (int i = 0; i < 10; i++) {}

        // 2. i 값 기반 (1 부터 10 까지 돌겠다.)
        for (int i = 1; i <= 10 ; i++) {}

        ////////////////////////////////////////



        for (int i = 1; i <= 5; i++) {
            for (int j = i + 1; j <= 5; j++) {
                System.out.printf("(%d, %d)\n", i, j);
            }
        }
        System.out.println();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i < j) System.out.printf("(%d, %d)\n", i, j);
            }
        }
    }
}
