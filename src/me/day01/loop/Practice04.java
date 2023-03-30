package me.day01.loop;

public class Practice04 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        int k = 1;
        while (k <= 5) {
            int l = 1;
            while (l <= 5) {
                System.out.print("*");
                l++;
            }
            System.out.println();
            k++;
        }

    }
}