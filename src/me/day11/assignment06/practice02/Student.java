package me.day11.assignment06.practice02;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private static int COUNT = 0;
    private String studentNo;
    private String name;

    private Integer score;

    private Integer order;

    public Student() {
    }

    public Student(String studentNo, String name, Integer score) {
        this.studentNo = studentNo;
        this.name = name;
        this.score = score;
        this.order = ++COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentNo, student.studentNo) && Objects.equals(name, student.name) && Objects.equals(score, student.score) && Objects.equals(order, student.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNo, name, score, order);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", order=" + order +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        String admissionYear = studentNo.substring(0, 4);
        String otherAdmissionYear = o.studentNo.substring(0, 4);

        if (admissionYear.compareTo(otherAdmissionYear) < 0) return -1;
        else if (admissionYear.compareTo(otherAdmissionYear) == 0) {
            return order.compareTo(o.order);
        }
        else return 1;

    }
}

