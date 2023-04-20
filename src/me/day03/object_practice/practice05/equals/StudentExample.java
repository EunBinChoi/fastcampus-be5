package me.day03.object_practice.practice05.equals;

public class StudentExample {
    public static void main(String[] args) {
        Student s1 = new Student("0001", "sally", 30);
        System.out.println(s1);
        System.out.println(s1.hashCode());
        System.out.println();

        Student s2 = new Student("0001", "sally", 30);
        System.out.println(s2);
        System.out.println(s2.hashCode());
        System.out.println();

        System.out.println(s1 == s2); // 주소값 비교
        System.out.println(s1.equals(s2)); // 내용물 비교

    }
}
