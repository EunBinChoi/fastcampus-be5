package me.day04;

import java.util.Arrays;

public class Practice04 {
    enum Comp {MIN, MAX};
    public static void main(String[] args) {
        int[] scores = new int[] {65, 50, 80, 90, 30, 70};
        System.out.println(minOrMax(scores, Comp.MIN));
        System.out.println(minOrMax(scores, Comp.MAX));
        System.out.println(average(scores));
        System.out.println(variance(scores));
        System.out.println(standard(scores));
    }
    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min < 0) min = arr[i];
        }
        return min;
    }
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - max > 0) max = arr[i];
        }
        return max;
    }
    // max: arr[i] - val > 0
    // min: -(arr[i] - val) > -0 => -arr[i] + val > 0 => 0 > arr[i] - val => arr[i] - val < 0

    // Sort (package (code): java.util.Timsort)
    public static int minOrMax(int[] arr, Comp compVal) {
        int val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if ((comp(compVal)) * (arr[i] - val) > 0) val = arr[i];
        }
        return val;
    }

    public static int comp(Comp comp) {
        return (comp == Comp.MIN) ? -1 : 1;
    }

    public static double average(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
    public static double variance(int[] arr) {
        double avg = average(arr);
        double var = 0;
        for (int i = 0; i < arr.length; i++) {
            var += Math.pow((arr[i] - avg), 2); // power
        }
        return var / arr.length;
    }
    public static double standard(int[] arr) {
        return Math.sqrt(variance(arr));
    }
}
