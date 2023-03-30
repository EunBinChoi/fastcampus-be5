package me.day01.operator;

public class Practice05 {
    public static void main(String[] args) {
        int num1 = 123456780;
        int num2 = 123456780;

        float num3 = num2;
        num2 = (int) num3;
        System.out.println(num3);
        System.out.println(num2);

        int result = num1 - num2;
        System.out.println(result);
        /*
         * int (num2) -> float (num3) 으로 바뀌면서 부동 소수점을 2진수로 표현하기 위해 오차가 발생함
         * 부동 소수점 오차에 의해 바뀐 float (num3) -> int (num2) 로 대입하면 오차가 발생했던 값을 정수로 바꿈
         *
         * 기존 정수 값 int (num1) 123456780 와 int (num2) 를 비교하면 오차에 의해 값이 차이날 수 있음
         * */
    }
}