package me.day03.object.practice04;

public class Main {
    public static void main(String[] args) {
//        Clazz clazz = new Clazz();
        Clazz clazz1 = Clazz.getInstance();
        Clazz clazz2 = Clazz.getInstance();

//        Clazz clazz1 = Clazz.instance;
//        Clazz clazz2 = Clazz.instance;

        System.out.print("same address? ");
        System.out.println(clazz1 == clazz2);
        System.out.println();

        System.out.println("set clazz1.field as -100");
        clazz1.setField(-100);
        System.out.println("clazz1? " + clazz1);
        System.out.println("clazz2? " + clazz2);
    }
}
