package me.qna;

class A {

}

class B {
    A a; // has-a

    public void method(A a) {
        // use-a
    }
}

public class Main {
    public static void main(String[] args) {
        // A a = new B();
    }
}
