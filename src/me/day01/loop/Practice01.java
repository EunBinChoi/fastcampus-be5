package me.day01.loop;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String answer = "";

        while(true) {
            char ch = scanner.next().charAt(0);
            if (ch == 'q') break; // q는 answer에 포함시키지 않을 것임

            answer = ch + answer;
        }

        System.out.println("answer = " + answer);

    }
}
