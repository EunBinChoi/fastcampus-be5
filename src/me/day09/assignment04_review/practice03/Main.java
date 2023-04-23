package me.day09.assignment04_review.practice03;

import me.day07.assignment04.practice03.Circle;
import me.day07.assignment04.practice03.Shape;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();
        System.out.println(shape);

        Circle circle = (Circle) new Shape();
        // 런타임 오류 발생 위치
        // java.lang.ClassCastException: class me.day07.assignment04.practice03.Shape cannot be cast to class me.day07.assignment04.practice03.Circle

        // 타입 변환이 불가능한 이유
        // - Shape 객체 생성시 만들어지는 필드는 center 밖에 없는데 Circle 로 형변환하면 center, radius 가 필요함
        // - 하지만 Shape 객체에는 radius 를 위한 메모리 공간이 없음
        // - 따라서 명시 형변환이 불가능함
        System.out.println(circle.getCenter());
        System.out.println(circle.getRadius());
    }
}
