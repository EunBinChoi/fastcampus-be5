package me.day10.smartstore.menu;

import me.day10.smartstore.customer.Customers;

public class Menu {
    // singleton
    private static Menu menu;

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    private Menu() {}
}
