package me.day07.oop_practice.practice02;

import java.util.Objects;

// 추상 클래스가 되려면 무조건 추상 메서드를 하나 이상 포함을 해야할까요?
// 추상 메서드가 하나 이상 있으면 추상 클래스이어야 함
// 추상 클래스가 되려면 추상 메서드가 하나 이상 포함되어야 하는 것은 아님

abstract class A { // 객체 생성이 불가능 (new 하기에는 너무 추상적임)
    public void a() {}
    public void b() {}
}


public abstract class Shape implements Drawable { // abstract class 는 인스턴스를 생성할 수 없음 (인스턴스를 생성하기에는 너무 추상적임)
    protected Point center;

    public Shape() {
    }

    public Shape(Point centerPoint) {
        this.center = centerPoint;
    }

    public Point getCenterPoint() {
        return center;
    }

    public void setCenterPoint(Point centerPoint) {
        this.center = centerPoint;
    }

//    public abstract void draw(); // abstract method 는 메소드의 정의만 존재하고 구현부가 없음
//    // 모든 자식들이 공유해야하는 메소드이긴 하지만 부모 클래스가 만들기에는 부모가 너무 추상적일 때
//    // 부모가 정의하지 않고 자식들이 재정의하도록 abstract method 만들 수 있음
//    // 부모가 abstract method 를 가지고 있으면 부모를 상속하는 자식들은 abstract method 를 무조건 재정의 (**)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(center, shape.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "center=" + center +
                '}';
    }
}
