package me.day01.condition;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double kor = scanner.nextDouble(); // 0 <=   <= 100
        if (!(kor >= 0 && kor <= 100)) {
            System.out.println("성적이 유효하지 않습니다.");
            return;
        }

        double math = scanner.nextDouble(); // 0 <=   <= 100
        if(!(math >= 0 && math <= 100)) {
            System.out.println("성적이 유효하지 않습니다.");
            return;
        }

        double eng = scanner.nextDouble(); // 0 <=   <= 100
        if(!(eng >= 0 && eng <= 100)) {
            System.out.println("성적이 유효하지 않습니다.");
            return;
        }

        double avg = (kor + math + eng) / 3.0;
        System.out.println("평균 = " + avg);

    }
}
