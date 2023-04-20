package me.day07.oop_practice.practice02;

import java.util.Objects;

public class Circle extends Shape implements Calculable {
    private int radius;

    public Circle() {
    }

    public Circle(Point centerPoint, int radius) {
        super(centerPoint);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
