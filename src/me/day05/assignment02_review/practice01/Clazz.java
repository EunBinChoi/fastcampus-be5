package me.day05.assignment02_review.practice01;

import java.util.Objects;

public class Clazz {
    private int a;
    private double b;
    private char c;
    private String s;

    public Clazz() {} // noArgumentConstructor

    public Clazz(int a, double b, char c, String s) { // allArgumentConstructor
        this.a = a;
        this.b = b;
        this.c = c;
        this.s = s;
    }

    // 1. setter&getter가 필요한 이유가 무엇인지 서술하시오.
    // - setter: public이 아닌 접근제어자로 정의된 필드값을 외부에서 수정하기 위함
    // - getter: public이 아닌 접근제어자로 정의된 필드값을 외부에서 반환하기 위함
    // 2. setter&getter가 없고 각 필드의 접근제어자가 `public`이면 어떤 문제가 생길 수 있는지 서술하시오.
    // - public이면 외부 클래스에서 필드를 임의로 수정할 수 있어 정보보호를 할 수 없음
    // - 외부에서 임의로 필드값을 수정하면 알고 있던 값이 아닌 이상한 값이 들어가 있을 수 있음 (내부에서 관리할 수 있는 방법이 없음, public이라 모두 접근 가능)
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    // equals()가 필요한 이유가 무엇인지 서술하시오.
    // - equals()는 우리가 정의한 객체의 비교방법을 정의하기 위함이다.
    // - 보통 객체 안에는 다양한 필드가 있기 때문에 필드값이 모두 같으면 같은 객체라고 정의한다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;

        // double: value
        // Double class: field + method
        return a == clazz.a && Double.compare(clazz.b, b) == 0 && c == clazz.c && Objects.equals(s, clazz.s);
    }

    // hashCode()가 필요한 이유가 무엇인지 서술하시오.
    // - hashCode()는 객체비교에서 해쉬코드가 다르면 두 객체가 다르다고 판단하기 위함 (객체비교를 신속하게 하기 위함)이다.
    // - 객체에 대한 hashCode()를 알게되면 객체비교시 int 값으로 먼저 비교할 수 있음
    // - 각 객체에 대한 고유 ID 값을 주기 위함이다. (하지만 int 값은 제한되어있기 때문에 충돌날 가능성은 있음)
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, s);
    }

    // toString()가 필요한 이유가 무엇인지 서술하시오.
    // - toString() 없이 객체변수를 출력하면 객체의 고유 ID 값이 나오는데 (객체변수에는 주소가 들어가있음, 주소 대신 사용하는 ID)
    // - 보통 우리가 변수를 출력한다는 것은 변수에 저장된 값이 궁금한 것이니까 값을 출력하기 위함
    @Override
    public String toString() { // sysout(new Clazz())
        return "Clazz{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", s='" + s + '\'' +
                '}';
    }

    /*
    *
    * 1. 만약 두 객체의 `hashCode()`가 같으면 같은 객체이다. (F) (hashCode 충돌에 의해 같다고 해도 다른 객체일 수 있음)
    * 2. 만약 두 객체의 `hashCode()`가 다르면 다른 객체이다. (T) (같은 객체는 무조건 hashCode가 같음, 따라서 hashCode가 다르면 다른 객체임)
    * 3. 두 객체를 비교할 때 먼저 `hashCode()`로 비교하면 빠른 비교가 가능하다. (T) (객체의 내용물보다 객체의 고유 ID (int)로 비교하는 게 빠름)
    * 4. 두 객체가 `equals()`에 의해 동일하다면 두 객체의 `hashCode()` 값도 일치해야 한다. (T) (같은 객체는 무조건 hashCode가 같음)
    * 5. `equals()`재정의하면`hashCode()`도 재정의해야 한다. (T) (같은 객체에 대해서 같은 값을 리턴하도록 구현해야 합)
    *
    * */
}
