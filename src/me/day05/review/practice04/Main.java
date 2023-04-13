package me.day05.review.practice04;

public class Main {
    public static void main(String[] args) {
        System.out.println(TeslaCar.getBrand());

        TeslaCar teslaCar = new TeslaCar();
        System.out.println(teslaCar.getBrand());
        // instance 없는 메소드를 접근하면 reflection class에 정의된 메소드인지를 확인

    }
}
