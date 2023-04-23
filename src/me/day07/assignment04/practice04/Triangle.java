package me.day07.assignment04.practice04;

import me.day09.assignment04_review.practice04.Point;
import me.day09.assignment04_review.practice04.Shape;

import java.util.Objects;

public class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle() {}

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public Triangle(Point center, int base, int height) {
        super(center);
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(Triangle.class.getName() + " draw()");
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return base == triangle.base && height == triangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", center=" + center +
                '}';
    }
}
