package me.day03.object_practice.practice05.tostring;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    /* auto-generated */
    private String ID; // 객체에 대한 고유한 값 (PK) (**)
    private String name;
    private Semester currentSemester;
    private String[] takenCourses;


    public Student() {}

    public Student(String name, Semester currentSemester, String[] takenCourses) {
        this.name = name;
        this.currentSemester = currentSemester;
        this.takenCourses = takenCourses;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return ID.equals(student.ID) && name.equals(student.name) && currentSemester == student.currentSemester && Arrays.equals(takenCourses, student.takenCourses);
//    }
    // null.equals(); // NullPointerException
    // name (not null).equals(null); // 에러가 나지 않을 수도 있음 (equals를 잘 만들었다는 가정 한에)
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(ID, name, currentSemester);
//        result = 31 * result + Arrays.hashCode(takenCourses);
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(ID, student.ID) && Objects.equals(name, student.name) && currentSemester == student.currentSemester && Arrays.equals(takenCourses, student.takenCourses);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ID, name, currentSemester);
        result = 31 * result + Arrays.hashCode(takenCourses);
        return result;
    }


    // hashcode가 같으면 두 객체가 같나요?
    // hashcode는 충돌날 수 있으니까

    // 두 객체를 비교할 때 hashcode()-> equals()

    // hashcode가 다르면 두 객체는 다른가요? (대우, T)
    // 두 객체가 같으면 hashcode는 같다 (T)


    @Override // Object 클래스에 정의 (재정의, 상속) (문법적인 추가 성질)
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", currentSemester=" + currentSemester +
                ", takenCourses=" + Arrays.toString(takenCourses) +
                '}';
    }
}
