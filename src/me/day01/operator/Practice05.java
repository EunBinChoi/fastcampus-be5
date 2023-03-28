package me.day01.operator;

public class Practice05 {
    public static void main(String[] args) {
        int num1 = 123456780;
        int num2 = 123456780;

        float num3 = num2; // 123456780.0f => 이진수 => 123456784.0f
        num2 = (int) num3;
        System.out.println(num3);
        System.out.println(num2);

        int result = num1 - num2;
        System.out.println(result);
    }
}
