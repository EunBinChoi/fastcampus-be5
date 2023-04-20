package me.day03.object_practice.practice03;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Sally", "991220-2000123", Semester.EXCEED);
        Employee general = new Employee("Kelly", false);
        Employee auth = new Employee("Kelly", true);

        System.out.println(student.getRegNum(general)); //
        System.out.println(student.getRegNum(auth)); //
        // student's regNum is gotten by general
        // student's regNum is gotten by auth

    }
}
