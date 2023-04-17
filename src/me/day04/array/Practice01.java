package me.day04.array;

class Arrayss {
    public static boolean equals(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return false;
        if (arr1 == arr2) return true;

        if (arr1.length != arr2.length) return false;

        // 모든 원소가 같아야 한다 (하나의 원소라도 다르면 안된다)
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static boolean equals(int[][] arr1, int[][] arr2) {
        if (arr1 == null || arr2 == null) return false;
        if (arr1 == arr2) return true;

        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            // 각각의 i번째 행을 비교해야 함

            if (!equals(arr1[i], arr2[i])) return false;
//            if (arr1[i] == null || arr2[i] == null) return false;
//            if (arr1[i] == arr2[i]) continue;
//
//            if (arr1[i].length != arr2[i].length) return false;
//
//            for (int j = 0; j < arr1[i].length; j++) {
//                if (arr1[i][j] != arr2[i][j]) return false;
//            }
        }
        return true;
    }


    // 함수의 오버로딩 (중복정의) vs (오버라이딩 (상속))
    // 조건
    // 1. 매개변수의 타입, 순서, 갯수
    // 2. 반환값은 안보나요? 반환값은 보지 않는다 (즉, 반환값이 다르다고 해서 함수의 중복정의 불가능)
//    public static int a() {
//        return 1;
//    }
//    public static boolean a() {
//        return true;
//    }
}

public class Practice01 {
    public static void main(String[] args) {
        System.out.println(Arrayss.equals(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}));
        System.out.println(Arrayss.equals(
                new int[][] {{1, 2, 3, 4, 5}, {1, 2, 4}, {}},
                new int[][] {{1, 2, 3, 4, 5}, {1, 2, 3}, {}}));

    }
}
