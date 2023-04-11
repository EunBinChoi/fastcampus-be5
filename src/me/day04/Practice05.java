package me.day04;

public class Practice05 {
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
    }
    // 1. double 평균 구하는 메서드 (일차원 배열)
    // 2. double[] 전체 평균을 구하는 메소드 (이차원 배열)
    public static double average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    public static double[] averageByStudents(int[][] scores) {
        double[] averages = new double[ROW];
        for (int i = 0; i < ROW; i++) { // 학생 번호
            int sum = 0;
            for (int j = 0; j < COL; j++) { // 과목 번호
                sum += scores[i][j];
            }
            averages[i] = (double) sum / COL;
        }
        return averages;
    }
    public static double[] averageBySubjects(int[][] scores) {

    }

    public static double[] sort() {
        // Arrays.sort() 없이 직접 구현
    }

}
