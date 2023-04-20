package me.day07.oop_practice.practice02;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(), new Rectangle(), new Triangle(), new Graph() };
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw(); // 동적 바인딩 (가상 메서드 테이블 기준으로)
        }
        System.out.println();

        Calculable[] calculables = {
                new Circle(new Point(3, 5), 2),
                new Rectangle(new Point(10, 20), 3, 5),
                new Triangle(new Point(30, 50), 2, 5) };
        for (int i = 0; i < calculables.length; i++) {
            double area = calculables[i].area();
            System.out.println(calculables[i].getClass().getName() + "'s area = " + area);
        }
        System.out.println();

    }
}
