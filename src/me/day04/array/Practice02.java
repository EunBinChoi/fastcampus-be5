package me.day04.array;

import java.util.Arrays;

public class Practice02 {
    public static void main(String[] args) {
//        System.out.println(Arrays.compare(null, null)); // 왜 오류가 날까?
        System.out.println(compare(null, null)); // 왜 오류가 안 날까? (정상)
        System.out.println();

        System.out.println(Arrays.compare(new int[]{1, 2, 3}, new int[]{2, 2, 3}));
        System.out.println(Arrays.compare(new int[]{2, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(Arrays.compare(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(Arrays.compare(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3}));
        System.out.println(compare(new int[]{1, 2, 3}, new int[]{2, 2, 3}));
        System.out.println(compare(new int[]{2, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(compare(new int[]{1, 2, 3}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(compare(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3}));

    }

    public static int compare(int[] a, int[] b) {
        if (a == b) return 0;
        if (a == null || b == null) return a == null ? -1 : 1;

        int minLength = Math.min(a.length, b.length);
        // a = {1,2,3,4,5}
        // b = {1,2,3,4,5,6,7}
        // 값 -> 사전식 비교

        // a가 더 작을 때 -1 (음수)
        // b가 더 작을 때 1 (양수)
        //       같을 때 0 (0)

        for (int i = 0; i < minLength; i++) {
            if (a[i] < b[i]) return -1;
            else if (a[i] > b[i]) return 1;
        }
        return a.length - b.length;
    }
}
