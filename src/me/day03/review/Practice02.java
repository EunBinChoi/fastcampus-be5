package me.day03.review;

public class Practice02 {
    public static void main(String[] args) {
        // a < b < c (가장 긴 변)
        int count = 0;
        for (int a = 1; a <= 100 ; a++) {
            for (int b = a + 1; b <= 100 ; b++) {
                for (int c = b + 1; c <= 100 ; c++) {
                    if (a * a + b * b == c * c) {
                        System.out.printf("(%d, %d, %d)\n", a, b, c);
                        count++;
                    }
                }
            }
        }
        System.out.println("total = " + count);
    }
}
