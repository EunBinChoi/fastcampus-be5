package me.day03.object_practice.practice05.compare;

import java.util.Objects;


public class Person implements Comparable<Person> { // Comparable: Person 클래스의 객체를 정렬할 때 사용하는 인터페이스
    private String name;
    private Gender gender;
    private String birthdate;
    private String registrationNumber;

    public Person() {}

    public Person(String name, Gender gender, String birthdate, String registrationNumber) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && gender == person.gender && Objects.equals(birthdate, person.birthdate) && Objects.equals(registrationNumber, person.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthdate, registrationNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthdate='" + birthdate + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }


//     객체에 담긴 필드는 여러개가 있는데 이 중에서 어떤 걸 기준으로 정렬할 것인가를 정의하는 메소드
//     o1.compareTo(o2)
//     o1 < o2: 음수 반환
//     o1 == o2: 0 반환
//     o1 > o2: 양수 반환

    // this         o
    // p1{name: b}, p2{name: a}, p3{name: z}, p4{name: c}, p5{name: d}
    // Arrays.sort(people);
    @Override
    public int compareTo(Person o) { // 오름차순
        // String: Java 자체 만든 클래스
        if (this.name.compareTo(o.name) < 0) return -1; // swap
        else if (this.name.compareTo(o.name) == 0) {
//            if (this.birthdate.compareTo(o.birthdate) < 0) return -1;
//            else if (this.birthdate.compareTo(o.birthdate) == 0) return 0;
//            else return 1;

            return this.birthdate.compareTo(o.birthdate);
        }
        else return 1; // this.name.compareTo(o.name) > 0

    }
}
