package me.day01.condition_practice;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 콘솔 (System) --> JVM 전달, 사용자 입력을 받음

        System.out.print("국어 성적 입력하시오: "); // 사용자 입력 유도 메시지
        double kor = scanner.nextDouble();
        if (!(kor >= 0 && kor <= 100)) {
            System.out.println("입력하신 성적 " + kor + " 유효하지 않습니다.");
            return;
        }

        System.out.print("수학 성적 입력하시오: ");
        double math = scanner.nextDouble();
        if (!(math >= 0 && math <= 100)) {
            System.out.println("입력하신 성적 " + math + " 유효하지 않습니다.");
            return;
        }

        System.out.print("영어 성적 입력하시오: ");
        double eng = scanner.nextDouble();
        if (!(eng >= 0 && eng <= 100)) {
            System.out.println("입력하신 성적 " + eng + " 유효하지 않습니다.");
            return;
        }

        double avg = (kor + math + eng) / 3;
        System.out.println("당신의 평균 점수는 " + avg + " 입니다.");
        if (avg >= 70) {
            System.out.println("=> 합격 !");
        }

        scanner.close();
    }
}