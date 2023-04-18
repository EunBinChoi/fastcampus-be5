package me.day01.assignment01;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    public static int input(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

}
