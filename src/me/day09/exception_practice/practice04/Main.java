package me.day09.exception_practice.practice04;

public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = Kiosk.getInstance(); // singleton
        kiosk.run(new User(10000));
    }
}
