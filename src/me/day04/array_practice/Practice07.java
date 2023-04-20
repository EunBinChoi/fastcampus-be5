package me.day04.array_practice;

import java.util.Scanner;

public class Practice07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // test case

        for (int i = 0; i < N; i++) {
            String score = scanner.next(); // 00XX00 => 1+2+0+0+1+2
            int count = 0; // 연속된 O의 개수
            int sum = 0; // 점수
            for (int j = 0; j < score.length(); j++) {
                if (score.charAt(j) == 'O') {
                    count++; // 문장
                } else {
                    count = 0; // 문장
                }
                sum += count;
            }
            System.out.println(sum);
        }

        scanner.close();
    }
}
