package me.day01.operator;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // console (시스템 상에 있음)

        System.out.print("제품의 총 가격을 입력하시오: "); // message 3000
        int productPrice = scanner.nextInt();
        double tax = productPrice * 0.1;
        double productTotal = productPrice + tax;

        System.out.print("사용자가 낸 돈을 입력하시오: "); // message 1000
        int payment = scanner.nextInt();

        if (productTotal > payment) {
            System.out.println("게산 불가능합니다.");
        } else { // productTotal <= payment
            double change = payment - productTotal;
            System.out.println("사용자가 받을 돈은 " + change + " 입니다.");
        }

        // "사용자가 받을 돈은 " + "1000.0" + " 입니다." => 문자열

    }
}
