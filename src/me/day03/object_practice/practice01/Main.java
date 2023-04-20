package me.day03.object_practice.practice01;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Sally", Semester.EXCEED);
        System.out.println(student1);

        Student student2 = new Student("John", Semester.FIRST);
        System.out.println(student2);

        Student student3 = new Student("Kim", Semester.SECOND);
        System.out.println(student3);

        Student student4 = new Student("Park", Semester.EIGHTH);
        System.out.println(student4);

        Student student5 = new Student("Min", Semester.FOURTH);
        System.out.println(student5);
    }
}
