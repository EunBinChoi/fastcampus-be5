package me.day07.abstracts;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(), new Rectangle(), new Triangle() };
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw(); // 동적 바인딩 (가상 메서드 테이블 기준으로)
        }

        Shape shape = new Shape() { // 익명 객체 (일회성 객체)
            @Override
            public void draw() {

            }

            @Override
            public double area() {
                return 0;
            }
        }; // abstract method (draw(), calculateArea())

        Shape shape1 = new Shape() {
            @Override
            public void draw() {

            }

            @Override
            public double area() {
                return 0;
            }
        };
    }
}
