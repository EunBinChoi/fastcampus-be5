package me.day03.review;

import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {

        User user = new User();
        user.setOriginalMoney(Utils.input("얼마 가지고 있니? "));

        Kiosk kiosk = Kiosk.getInstance();
        kiosk.order(user);

    }

}
