package me.day09.exception.java_examples.basics;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        if (str != null) { // 실행하기 전에 핸들링할 수 있으면 하는 게 좋음 (if >>>>> try ~ catch)
            System.out.println(str.length());
        }
        System.out.println("finally block");
        System.out.println("main method exit...");

        ////////////////////////////////////////////////
        try {
            System.out.println(str.length()); // 일단 실행하고
        } catch (NullPointerException e) { // 나중에 처리하겠다!
            e.printStackTrace();
            // log
        } finally {
            System.out.println("finally block");
        }
        System.out.println("main method exit...");





    }
}
