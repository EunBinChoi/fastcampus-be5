package me.day11.thread.basics;

public class MyThread extends Thread { // 스레드를 만듦
    private static final int ITERATIONS = 10;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() { // 독립적인 작업을 하는 단위
        for (int i = 0; i < ITERATIONS; i++) {
            System.out.println(name + " => " + i);
        }
    }

    @Override
    public String toString() {
        return "MyThread{" +
                "name='" + name + '\'' +
                '}';
    }
}
