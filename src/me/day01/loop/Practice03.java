package me.day01.loop;

import java.util.Scanner;

public class Practice03 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        final int NUM = 5;
        double sum = 0;
        double avg = 0;
        double validAnswer = 0;

        for(int i = 0; i < NUM; i++) {
            validAnswer = inputAnswer();
            sum += validAnswer;
        }
        avg = sum / NUM;
        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
    }

    public static double inputAnswer(){
        double temp;
        while(true) {
            temp = sc.nextDouble();
            if (temp >= 0 && temp <= 100) break;
        }
        return temp;
    }
}
