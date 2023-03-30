package me.day01.condition;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("(x, y) : "); // "(1, 2)"

        String point = scanner.nextLine();
        point = point.replace("(", ""); // String Method
        point = point.replace(")", ""); // String Method
        String[] strings = point.split(",");

        double x = Double.parseDouble(strings[0]);
        double y = Double.parseDouble(strings[1]);

        if (x == 0 && y == 0) {
            System.out.println("at center");
        } else if (x == 0) {
            System.out.println("on y-axis");
        } else if (y == 0) {
            System.out.println("on x-axis");
        } else if (x > 0 && y > 0) {
            System.out.println("at 1 quadrant");
        } else if (x < 0 && y > 0) {
            System.out.println("at 2 quadrant");
        } else if (x < 0 && y < 0) {
            System.out.println("at 3 quadrant");
        } else {
            System.out.println("at 4 quadrant");
        }

        scanner.close();
    }
}