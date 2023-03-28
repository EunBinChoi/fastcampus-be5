package me.day01.condition;

public class Practice03 {
    public static void main(String[] args) {

        double x = 1.5;
        double y = 0;

        if (x == 0) {

        } else if (y == 0) {

        } else if (x >0 && y >0) { // 1

        } else if (x >0 && y >0) {//2

        } else if (x >0 && y >0) { // 3

        } else if (x >0 && y >0) { //4

        }

        // 90 80 70 60 other

        double avg = 80;
        if (avg >= 90) {
            System.out.println("A");
        } else if (avg >= 80) { // 80 <= avg < 90
            System.out.println("B");
        } else if (avg >= 70) { // 70 <= avg < 80
            System.out.println("C");
        } else if (avg >= 60) { // 60 <= avg < 70
            System.out.println("D");
        } else { // avg < 60
            System.out.println("D");
        }
    }
}
