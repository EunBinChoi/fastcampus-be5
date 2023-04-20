package me.day01.loop_practice;

// 5명의 성적을 입력받아 합계와 평균을 구하는 프로그램

import java.util.Scanner;

public class Practice03 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        final int NUM = 5;
        double sum = 0;
        double avg = 0;

        for(int i = 0; i < NUM; i++) {
            sum += inputScore(i);
        }
        avg = sum / NUM;
        System.out.println("\n===========================");
        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
    }
    public static double inputScore(int i) {
        while (true) {
            System.out.printf("%d 학생의 성적 입력: ", i + 1);
            double score = sc.nextDouble();
            if (!(score >= 0 && score <= 100)) {
                System.out.println("유효하지 않은 성적 입력값입니다");
                continue;
            }
            return score;
        }
    }
}