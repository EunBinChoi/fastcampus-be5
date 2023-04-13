package me.day05.review.practice06;

public class Main {
    static final int DEFAULT = 10;
    public static void main(String[] args) {
        Clazz[] clazzes = new Clazz[DEFAULT];

        for (int i = 0; i < clazzes.length; i++) {
            clazzes[i] = new Clazz(); // 매번 새로운 a, b가 생김
            System.out.println(clazzes[i]);
        }
        System.out.println();

        GoodClazz[] goodClazzes = new GoodClazz[DEFAULT];
        for (int i = 0; i < goodClazzes.length; i++) {
            goodClazzes[i] = new GoodClazz();
            System.out.println(goodClazzes[i]);
        }
        System.out.println();

        A a = new A();
        B b = new B();
        for (int i = 0; i < goodClazzes.length; i++) {
            goodClazzes[i].setA(a); // 하나의 a, b를 주입함
            goodClazzes[i].setB(b); // 하나의 a, b를 주입함
            System.out.println(goodClazzes[i]);
        }

    }
}
