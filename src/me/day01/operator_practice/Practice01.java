package me.day01.operator_practice;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);

        System.out.print("총 금액 : ");
        double price = scanner.nextDouble();
        double total = price + price * 0.1;
        String totalString = numberFormat.format(total);
        System.out.println("노트북 금액 (부과세 포함)은 " + totalString + " 입니다.");

        System.out.print("받은 돈 : ");
        double money = scanner.nextDouble();
        String moneyString = numberFormat.format(money);
        System.out.println("받은 돈은 " + moneyString + " 입니다.");

        double change = money - total;
        String changeString = numberFormat.format(change);
        System.out.println("\n=> 잔돈은 " + changeString + " 입니다.");

        scanner.close();
    }
}
