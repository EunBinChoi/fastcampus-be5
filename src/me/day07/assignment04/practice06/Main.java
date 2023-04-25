package me.day07.assignment04.practice06;

public class Main {
    public static void main(String[] args) {
        Park park = new Park("에버랜드", 50000.0);
        Person[] persons = {new Person(), new Worker(), new Student(), new UnivStudent(), new HighStudent(), new Kid()};

        System.out.println("<< 할인 적용한 입장료 계산 결과 >>");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].getClass().getName() + " => " + park.getFee(persons[i]) + "원");
        }
    }
}
