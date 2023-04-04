package me.day03.review;

public class Practice01 {
    public static void main(String[] args) {
        // i: 1 ~ 5

        // (1, 2)
        // 수 지정
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
