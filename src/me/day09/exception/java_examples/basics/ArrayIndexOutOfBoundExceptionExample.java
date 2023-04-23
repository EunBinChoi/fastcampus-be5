package me.day09.exception.java_examples.basics;

public class ArrayIndexOutOfBoundExceptionExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // arr[5] = 100;
        try {
            for (int i = 0; i <= arr.length; i++) { // 개발자 실수 (코드를 직접적으로 수정해야 함), (실무에서는 이런 경우를 try~catch 사용 안함)
                System.out.println(arr[i]); // i == arr.length
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("main exit ...");
    }
}
