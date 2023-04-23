package me.day07.assignment04.practice04;

import me.day09.assignment04_review.practice04.Point;
import me.day09.assignment04_review.practice04.Shape;

import java.util.Objects;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {}

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point center, int width, int height) {
        super(center);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(Rectangle.class.getName() + " draw()");
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", center=" + center +
                '}';
    }
}
