package me.day04;

import java.util.Arrays;

public class Practice03 {
    public static void main(String[] args) {
        int[] original = new int[] {1, 2, 3, 4, 5};
        int[] copy1 = Arrays.copyOf(original, 10); // 5까지만 복사할 것 같은데
        System.out.println(Arrays.toString(copy1));

        int[] copy2 = Arrays.copyOfRange(original, 1, 10); // ??
        // from: 포함됨, to: 포함되지 않음
        System.out.println(Arrays.toString(copy2));
    }
    public static int[] copy(int[] original, int newLength) {
        if (original == null) return null;

        int[] copy = new int[original.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
    public static int[] copy(int[][] original) {

    }
}
