package me.day01.operator;

public class Practice07 {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int res = ((i < j) || (i == 3)) ? i : j; // 연산자의 단축 계산 (컴파일러 최적화)
        int res2 = ((i > j) && (i == 3)) ? i : j; // 연산자의 단축 계산 (컴파일러 최적화)

        System.out.println("res = " + res);
        System.out.println("res2 = " + res2);

    }
}
