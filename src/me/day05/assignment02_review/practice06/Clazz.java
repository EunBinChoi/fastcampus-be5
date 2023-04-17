package me.day05.assignment02_review.practice06;


/*
 * 아래 클래스를 정의하고 아래의 객체 생성 방법이 객체의 관계 상 좋지 않은 이유를 설명하시오.
 * - Clazz 클래스의 객체가 생성될 때마다 A, B 클래스의 객체가 생성되기 때문에 A, B 클래스의 객체가 몇 개가 생겼는지 관리하기 어렵다.
 * - 이렇게 하기 보다는 외부에서 A, B 클래스의 객체를 만들고 생성자나 setter를 통해 주입하는 것이 좋다.
 * */

class A {}
class B {}

public class Clazz {
    private A a;
    private B b;

    public Clazz() {
        a = new A();
        b = new B();
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}