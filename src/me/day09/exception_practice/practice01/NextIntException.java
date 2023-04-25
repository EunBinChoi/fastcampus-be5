package me.day09.exception_practice.practice01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NextIntException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.print(">> input number : ");
                int number = scanner.nextInt(); // new InputMismatchException()
                System.out.println("number = " + number);
                break;
            } catch (InputMismatchException e) {
                String typeError = scanner.next();
                System.out.printf("you type '%s', but it is not a number\n", typeError);
            } finally {
                System.out.println("finally");
            }
        }
        scanner.close();
    }
}
