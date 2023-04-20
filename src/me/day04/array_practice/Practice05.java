package me.day04.array_practice;

import java.util.Arrays;

public class Practice05 {
    enum Order {ASC, DESC}
    public static void main(String[] args) {

        final int STUDENT_NUM = 5; // row
        final int SUBJECT_NUM = 3; // col

        int[][] scores2d = {
                { 50,  60,  70},
                { 60,  76, 100},
                { 95,  88,  87},
                { 60,  65,  85},
                {100,  85,  77}
        };

        // 정렬하기 위해 저장
        String[] subjectsName = { "국어", "수학", "영어" };
        int[] subjects = new int[SUBJECT_NUM]; // subject index
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = i; // 0 ~ 2
        }

        int[] students = new int[STUDENT_NUM]; // student index
        for (int i = 0; i < students.length; i++) {
            students[i] = i; // 0 ~ 4
        }
        double[] subjectsAverage = calculateSubjectsAverage(scores2d);
        double[] studentsAverage = calculateStudentsAverage(scores2d);
        System.out.println("subject's average => " + Arrays.toString(subjectsAverage));
        System.out.println("student's average => " + Arrays.toString(studentsAverage));
        System.out.println();

        // subjectsAverage, subjects
        // call by reference: 참조자 (c++) (X)
        // call by (address) value
        sort(subjectsAverage, subjects, Order.DESC);
        System.out.println("[ subject's average by descending order ]");
        System.out.println("\n-----------------------------------------------");
        System.out.println(Arrays.toString(subjects));
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%12s | ", subjectsName[subjects[i]]);
        }
        System.out.println("\n-----------------------------------------------");
        for (int i = 0; i < subjectsAverage.length; i++) {
            System.out.printf("%12f  | ", subjectsAverage[i]);
        }
        System.out.println("\n-----------------------------------------------");

        System.out.println();
        sort(studentsAverage, students, Order.ASC);
        System.out.println("[ student's average by ascending order ]");
        System.out.println(Arrays.toString(students));
        System.out.println("\n--------------------------------------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.printf("%10s  | ", students[i] + 1 + "번 학생");
        }
        System.out.println("\n--------------------------------------------------------------------------");
        for (int i = 0; i < studentsAverage.length; i++) {
            System.out.printf("%12f | ", studentsAverage[i]);
        }
        System.out.println("\n--------------------------------------------------------------------------");
    }

    public static double[] calculateSubjectsAverage(int[][] scores2d) {
        double[] subjectAverage = new double[scores2d[0].length]; // 각 과목별 학생 성적 평균

        for (int i = 0; i < scores2d[0].length; i++) { // COLUMN
            int sum = 0;
            for (int j = 0; j < scores2d.length; j++) { // ROW
                sum += scores2d[j][i];
            }
            subjectAverage[i] = (double) sum / scores2d.length;
        }
        return subjectAverage;
    }

    public static double[] calculateStudentsAverage(int[][] scores2d) {
        double[] studentsAverage = new double[scores2d.length]; // 각 학생별 과목 성적 평균

        for (int i = 0; i < scores2d.length; i++) { // ROW
            int sum = 0;
            for (int j = 0; j < scores2d[0].length; j++) { // COLUMN
                sum += scores2d[i][j];
            }
            studentsAverage[i] = (double) sum / scores2d[0].length;
        }
        return studentsAverage;
    }

    public static int compare(Order order) {
        return (order == Order.ASC) ? 1 : -1;
    }

    public static void sort(double[] array, int[] index, Order order) {
        int comp = compare(order);

        // bubble sort
        // (10, 20, 5, 1, 2)
        // ( 0,  1, 2, 3, 4)

        // 1번째 반복문 i == 1
        // (10, 20, 5, 1, 2)
        // (10, 5, 20, 1, 2)
        // (10, 5, 1, 20, 2)
        // (10, 5, 1, 2, // 20) // 가장 큰 놈이 뒤에 있음

        // 2번째 반복문 i == 2
        // (5, 10, 1, 2, // 20)
        // (5, 1, 10, 2 // 20)
        // (5, 1, 2, // 10 // 20) // 두번째 큰 놈이 뒤에 있음

        // 3번째 반복문 i == 3
        // (1, 5, 2, // 10, 20)
        // (1, 2, // 5, // 10, 20)

        // 4번째 반복문 i == 4
        // (1, // 2, 5, 10, 20)

        for (int i = array.length - 1; i > 0; i--) { // n 숫자 정렬시 반복해야하는 횟수 -> n - 1
            for (int j = 0; j < i; j++) {
                // 오름차순 (array[j] > array[j + 1]) [2, 1] => [1, 2]
                //        (array[j] - array[j + 1] > 0)
                // 내림차순 (array[j] < array[j + 1]) [1, 2] => [2, 1]
                //        (array[j] - array[j + 1] < 0)


                /*
                 * (array[j] - array[j + 1] > 0)
                 * (array[j] - array[j + 1] (*-1) > 0)
                 * -array[j] + array[j + 1] > 0
                 * 0 > array[j] - array[j + 1]
                 * array[j] - array[j + 1] < 0
                 * */

                if ((array[j] - array[j + 1]) * comp > 0) {
                    // swap
                    double value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;

                    // swap
                    int idx = index[j]; // 학생번호, 과목번호 (국, 수, 영)
                    index[j] = index[j + 1];
                    index[j + 1] = idx;
                }
            }
        }
    }

}
