package me.day08.api_practice;

import java.util.StringTokenizer;

public class Practice02 {
    public static void main(String[] args) {
        String str = "";

        for (int i = 0; i < 100000; i++) {
            str += i + ", ";
        }

        final String STR = str;

        //////////////////////////////////////////

        /* 새로운 공간을 만들어 반환하기 때문에 복사하는 시간으로 속도가 느려짐 */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                String[] splits = STR.split(", ");
                long end = System.currentTimeMillis();
                System.out.printf("%s: %5d ms\n", Thread.currentThread().getName(), end - start);
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                StringTokenizer stringTokenizer = new StringTokenizer(STR, ", ");

                while (stringTokenizer.hasMoreTokens()) {
                    String token = stringTokenizer.nextToken();
                }
                long end = System.currentTimeMillis();
                System.out.printf("%s: %5d ms\n", Thread.currentThread().getName(), end - start);
            }
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}
