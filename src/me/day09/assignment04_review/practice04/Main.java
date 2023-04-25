package me.day09.assignment04_review.practice04;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(3),
                new Rectangle(3, 5),
                new Triangle(5, 3)};

        for (int i = 0; i < shapes.length; i++) {
            Point point = new Point((int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1);
            shapes[i].setCenter(point);
        }

        System.out.println("[ Shapes ] ");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getClass().getName() + " = " + shapes[i]);
        }
        System.out.println();

        System.out.println("[ Shapes' area ] ");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getClass().getName() + " = " + area(shapes[i]));
            System.out.println(shapes[i].getClass().getName() + " = " + shapes[i].area()); // 동적 바인딩
        }
        System.out.println();

    }

    // 객체지향적이지 않은 코드 🤔
    public static double area(Shape shape) {
        final double PI = Math.PI;
        if (shape instanceof Circle) {
            return ((Circle) shape).getRadius() * ((Circle) shape).getRadius() * PI;
        } else if (shape instanceof Rectangle) {
            return ((Rectangle) shape).getWidth() * ((Rectangle) shape).getHeight();
        } else if (shape instanceof Triangle) {
            return ((Triangle) shape).getBase() * ((Triangle) shape).getHeight() * 0.5;
        } else {
            return 0.0;
        }
    }
}
