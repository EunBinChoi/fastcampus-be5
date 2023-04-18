package me.day07.assignment04.practice06;

import java.util.Objects;

public class Person {
    enum Gender {MALE, FEMALE, OTHERS}
    private String name;
    private String regNum;
    private Gender gender;

    public Person() {
    }

    public Person(String name, String regNum) {
        this.name = name;
        this.regNum = regNum;
    }

    public Person(String name, String regNum, Gender gender) {
        this.name = name;
        this.regNum = regNum;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(regNum, person.regNum) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, regNum, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", regNum='" + regNum + '\'' +
                ", gender=" + gender +
                '}';
    }
}
