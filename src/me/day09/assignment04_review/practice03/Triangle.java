package me.day09.assignment04_review.practice03;

import me.day07.assignment04.practice03.Point;
import me.day07.assignment04.practice03.Shape;

import java.util.Objects;

public class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle() {}

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public Triangle(Point centerPoint, int base, int height) {
        super(centerPoint);
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
