package me.day07.assignment04.practice03;

import java.util.Objects;

public class Circle extends Shape {
    private int radius;

    public Circle() {}

    public Circle(int radius) {
        this.radius = radius;
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
