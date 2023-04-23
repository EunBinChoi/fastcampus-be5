package me.day09.assignment05.practice05;

public class Main {
    public static void main(String[] args) {
        // clone method 이용
        Clazz objectCopyExample1 = new Clazz(10, "abc",
                new Person[] {
                        new Person("a", Person.Gender.MALE, "19880101", "19880101-1234567"),
                        new Person("b", Person.Gender.FEMALE, "19900320", "19900320-2345678"),
                        new Person("c", Person.Gender.FEMALE, "19960830", "19960830-2012020")});
        Clazz objectCopyExample2 = null;
        try {
            objectCopyExample2 = objectCopyExample1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("주소값 비교 = " + (objectCopyExample1 == objectCopyExample2));
        System.out.println(objectCopyExample1);
        System.out.println(objectCopyExample2);
        System.out.println();
        System.out.println("배열 주소값 비교 = " + (objectCopyExample1.getPersonArray() == objectCopyExample2.getPersonArray()));
        System.out.println("객체 주소값 비교 = " + (objectCopyExample1.getPersonArray()[0] == objectCopyExample2.getPersonArray()[0]));

        // 원소값 수정
        objectCopyExample1.getPersonArray()[0].setName("d");
        System.out.println(objectCopyExample1.getPersonArray()[0]);
        System.out.println(objectCopyExample2.getPersonArray()[0]);
        System.out.println();

    }
}
