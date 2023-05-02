package me.day11.generic.bound.nonitem;

import java.util.Objects;

public class Person {
    private String name;
    private String age;
    private String regNum;

    public Person() {
    }

    public Person(String name, String age, String regNum) {
        this.name = name;
        this.age = age;
        this.regNum = regNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(regNum, person.regNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, regNum);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", regNum='" + regNum + '\'' +
                '}';
    }
}
