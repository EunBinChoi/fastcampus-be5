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
        System.out.println();
        /////////////////////////////////////////////////////////////

        int[] arr1d = new int[] {1, 2, 3, 4, 5};
        int[][] arr2d = new int[][] {{1, 2, 3, 4, 5}, {1, 2, 3}, {1}, null};
        System.out.println(Arrays.toString(copy(arr1d, 10)));
        System.out.println(Arrays.toString(copy(arr1d, 0)));
        System.out.println(Arrays.toString(copy(arr1d, -1)));
        System.out.println();
        System.out.println(Arrays.deepToString(copy(arr2d, 5, 5)));
        System.out.println(Arrays.deepToString(copy(arr2d, 3, 5)));
        System.out.println(Arrays.deepToString(copy(arr2d, 0, 5)));
        System.out.println(Arrays.deepToString(copy(arr2d, -1, 5)));
    }
    public static int[] copy(int[] original, int newLength) {
        if (original == null) return null;
        if (newLength < 0) return null;

        int[] copy = new int[newLength];
        int minLength = Math.min(original.length, newLength);
        for (int i = 0; i < minLength; i++) {
            copy[i] = original[i];
        }
        return copy;
    }
    public static int[][] copy(int[][] original, int newRow, int newCol) {
        if (original == null) return null;
        if (newRow < 0 || newCol < 0) return null;

        int[][] copy = new int[newRow][newCol];
        int minRow = Math.min(original.length, newRow);

        for (int i = 0; i < minRow; i++) {
            if (original[i] == null) return null;
            int minCol = Math.min(original[i].length, newCol);

            for (int j = 0; j < minCol; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }
}
