package me.day04;

import java.util.Arrays;

public class Practice05 {
    enum Order {ASC, DESC}
    static final int ROW = 5;
    static final int COL = 3;
    public static void main(String[] args) {
        int[][] scores2d = {
                { 50,  60,  70},
                { 60,  76, 100},
                { 95,  88,  87},
                { 60,  65,  85},
                {100,  85,  77}
        };

        int[] studentIdx = new int[ROW];
        for (int i = 0; i < ROW; i++) {
            studentIdx[i] = i; // 0 ~ 4 {학생번호}
        }

        String[] subjectName = new String[] {"국어", "수학", "영어"};
        int[] subjectIdx = new int[COL];
        for (int i = 0; i < COL; i++) {
            subjectIdx[i] = i; // 0 ~ 2 {과목번호 {국=0, 수=1, 영=2}}
        }

        double[] studentAvgs = averageByStudents(scores2d);
        double[] subjectAvgs = averageBySubjects(scores2d);
        System.out.println(Arrays.toString(studentAvgs));
        System.out.println(Arrays.toString(subjectAvgs));
        System.out.println();

        sort(studentAvgs, studentIdx, Order.ASC);
        System.out.println(Arrays.toString(studentIdx));
        System.out.println(Arrays.toString(studentAvgs));
        System.out.println();

        sort(subjectAvgs, subjectIdx, Order.ASC);
        System.out.println(Arrays.toString(subjectIdx));
        System.out.println(Arrays.toString(subjectAvgs));
        System.out.println();

        sort(studentAvgs, studentIdx, Order.DESC);
        System.out.println(Arrays.toString(studentIdx));
        System.out.println(Arrays.toString(studentAvgs));
        System.out.println();

        sort(subjectAvgs, subjectIdx, Order.DESC);
        System.out.println(Arrays.toString(subjectIdx));
        System.out.println(Arrays.toString(subjectAvgs));

    }

    public static double[] averageByStudents(int[][] scores) {
        double[] averages = new double[ROW];
        for (int i = 0; i < ROW; i++) { // 학생 번호
            double sum = 0;
            for (int j = 0; j < COL; j++) { // 과목 번호
                sum += scores[i][j];
            }
            averages[i] = sum / COL;
        }
        return averages;
    }
    public static double[] averageBySubjects(int[][] scores) {
        double[] averages = new double[COL];
        for (int i = 0; i < COL; i++) { // 과목 번호
            double sum = 0;
            for (int j = 0; j < ROW; j++) { // 학생 번호
                sum += scores[j][i];
            }
            averages[i] = sum / ROW;
        }
        return averages;
    }

    // {}
    public static void sort(double[] array, int[] index, Order order) { // comp: 1 (asc), -1 (desc)
        // bubble sort
        // (*) input array에서 부동소수점의 문제로 인한 크기비교 불가는 무시한다.

        int comp = order == Order.ASC ? 1 : -1;

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if ((array[j] - array[j+1]) * comp > 0) {
                    double tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;

                    int idx = index[j];
                    index[j] = index[j+1];
                    index[j+1] = idx;
                }
            }
        }

    }

}
