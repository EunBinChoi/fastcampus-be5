package me.day07.assignment04.practice04;

import me.day09.assignment04_review.practice04.Point;

import java.util.Objects;

public abstract class Shape {

    protected Point center;

    public Shape() {}

    public Shape(Point center) {
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public abstract void draw();
    public abstract double area();

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
