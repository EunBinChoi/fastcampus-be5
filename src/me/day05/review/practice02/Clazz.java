package me.day05.review.practice02;

public class Clazz {
    private int a;
    private double b;
    private char c;
    private String s;
    private String ss; // new field

//    public Clazz(String s) {
//        this.s = s;
//    }
//    public Clazz(String ss) {
//        this.s = s;
//    }

    // 오류나는 이유
    // - 함수의 오버로딩은 함수의 이름은 같고, 매개변수의 순서, 타입, 개수가 다르게 정의되는 것을 말한다.
    // - 하지만 위의 케이스 같은 경우, 변수 이름은 다르지만 (오버로딩과 상관없음) 매개변수 타입이 동일하기 때문에 오버로딩이 아니다.
    // - 그냥 동일한 메소드 `public Clazz(String){}`이 두 번 정의된 것이기 때문에 오류가 난다.

}