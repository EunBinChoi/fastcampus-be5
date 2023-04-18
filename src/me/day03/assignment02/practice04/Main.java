package me.day03.assignment02.practice04;

import me.day05.assignment02_review.practice04.TeslaCar;

public class Main {
    public static void main(String[] args) {
        System.out.println(TeslaCar.getBrand());

        TeslaCar teslaCar = new TeslaCar();
        System.out.println(teslaCar.getBrand());
        // instance 없는 메소드를 접근하면 reflection class에 정의된 메소드인지를 확인

    }
}
