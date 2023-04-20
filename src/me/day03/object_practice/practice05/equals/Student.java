package me.day03.object_practice.practice05.equals;

import java.util.Objects;

public class Student {
    private String studentId;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(studentId, student.studentId) && Objects.equals(name, student.name);
    }

    // equals() 함수의 효율성을 높여주기 위한 용도
    // 1. hashCode 가 다르면 두 객체는 다름 (equals()를 보지 않아도 됨)
    // 2. hashCode 가 같으면 두 객체는 같을 수도 있고 다를 수도 있음 (충돌) => equals()을 봐서 정말 같은 객체인지 확인

    // ex) s1.hasCode: 132, s2.hashCode: 211 => hashCode() => equals() 볼 필요 없음
    // ex) s1.hasCode: 132, s2.hashCode: 132 => hashCode() => equals() 확인 후 정말 같은 놈인지를 체킹

    @Override
    public int hashCode() {
        // 객체를 해슁하기 위해 만든 코드
        // 해쉬코드 = 객체를 identification 하기위해 만든 코드
        // 객체마다 해쉬코드가 같으면 안됨 (* 31 (소수))
        // studentId * 31^(2) + name * 31^(1) + age * 31^(0) = hashCode
        return Objects.hash(studentId, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
