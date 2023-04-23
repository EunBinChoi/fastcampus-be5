package me.day09.exception_practice.practice05;

public class Main {
    static Members members = Members.getInstance();
    static ShoppingItems shoppingItems = ShoppingItems.getInstance();


    public static void main(String[] args) {
        System.out.println("<<initialize>>");
        members.init();
        System.out.println(members);

        shoppingItems.init();
        System.out.println(shoppingItems);
        System.out.println();
    }

}
