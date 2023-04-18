package me.day01.assignment01;

public class Practice04 {
    public static void main(String[] args) {

        User user = new User();
        user.setOriginalMoney(Utils.input("얼마 가지고 있니? "));

        Kiosk kiosk = Kiosk.getInstance();
        kiosk.order(user);

    }

}
