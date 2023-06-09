package me.day07.abstracts;

import java.util.Objects;

public class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle() {
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
    public void draw() {
        System.out.println(Triangle.class.getName() + " draw()");
    }

    @Override
    public double area() {
        return base * height * 0.5;
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
