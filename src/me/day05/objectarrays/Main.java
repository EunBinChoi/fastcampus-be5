package me.day05.objectarrays;

public class Main {
    static Members members = Members.getInstance();
    static ShoppingItems shoppingItems = ShoppingItems.getInstance();
    static ShoppingCarts shoppingCarts = ShoppingCarts.getInstance();
    public static void main(String[] args) {
        members.init();
        System.out.println(members);
        System.out.println();

        shoppingItems.init();
        System.out.println(shoppingItems);
    }
}
