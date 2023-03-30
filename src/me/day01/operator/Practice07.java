package me.day01.operator;

/*
* Scanner 클래스 안에 왜 nextChar가 없을까?
*
* System.in => InputStream 클래스의 객체
*
* char => 2byte, 유니코드
*
* InputStream 클래스 => byte 단위로 문자를 읽음 (영문자는 읽음, 한국어 깨짐)
* Reader 클래스 => 문자 단위로 읽음 (2byte)
*
*
* */

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
