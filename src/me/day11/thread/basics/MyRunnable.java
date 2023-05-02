package me.day11.thread.basics;

public class MyRunnable implements Runnable { // 스레드 내부에 작업단위 기술
    private static final int ITERATIONS = 10;
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < ITERATIONS; i++) {
            System.out.println(name + " => " + i);
        }
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "name='" + name + '\'' +
                '}';
    }
}
